package org.smartapplication.services.Implementations;

import org.smartapplication.dtos.request.Auth.LoginRequest;
import org.smartapplication.dtos.request.Auth.RegistrationRequest;
import org.smartapplication.dtos.response.Admin.AdminRegistrationResponse;
import org.smartapplication.dtos.response.Auth.LoginResponse;
import org.smartapplication.dtos.response.Auth.RegistrationResponse;
import org.smartapplication.dtos.response.Customer.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.Vendor.VendorRegistrationResponse;
import org.smartapplication.exceptions.UserNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.*;
import org.smartapplication.model.Enums.Roles;
import org.smartapplication.repositories.AdminRepository;
import org.smartapplication.repositories.CustomerRepository;
import org.smartapplication.repositories.UserRepository;
import org.smartapplication.repositories.VendorRepository;
import org.smartapplication.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final VendorStoreIdImpl vendorStoreIdImpl;


    public UserServiceImpl(UserRepository userRepository, VendorRepository vendorRepository, CustomerRepository customerRepository, AdminRepository adminRepository, VendorStoreIdImpl vendorStoreIdImpl) {
        this.userRepository     = userRepository;
        this.vendorRepository   = vendorRepository;
        this.customerRepository = customerRepository;
        this.adminRepository    = adminRepository;
        this.vendorStoreIdImpl = vendorStoreIdImpl;
    }

    public User getUserEmail( String email){
        return userRepository.findByEmail(email);
    }
    
    @Override
    public RegistrationResponse create(RegistrationRequest request) throws VendorNotFoundException {
        //TODO: T-Gurl, Check for an ealier registration before trying to create a new one
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setPhone(request.getPhone());
        newUser.setRoles(request.getRoles());

        User createdUser = userRepository.save(newUser);

        Admin createdAdmin = null;
        Customer createdCustomer = null;
        Vendor createdVendor = null;

        if(Roles.ADMIN.equals(request.getRoles())){
            Admin admin = new Admin();
            admin.setIsActive(request.getAdminRegistrationRequest().getIsActive());
            admin.setUser(createdUser);
            createdAdmin = adminRepository.save(admin);

        }else if(Roles.CUSTOMER.equals(request.getRoles())){

            Customer customer = new Customer();
            customer.setAddress(request.getCustomerRegistrationRequest().getAddress());
            customer.setLocation(request.getCustomerRegistrationRequest().getLocation());
            customer.setUser(createdUser);
            createdCustomer = customerRepository.save(customer);

        }else if(Roles.VENDOR.equals(request.getRoles())){

            Vendor vendor = new Vendor();
            vendor.setCompanyName(request.getVendorRegistrationRequest().getCompanyName());
            vendor.setCompanyAddress(request.getVendorRegistrationRequest().getCompanyAddress());
            vendor.setLocation(request.getVendorRegistrationRequest().getLocation());
            vendor.setRegNo(request.getVendorRegistrationRequest().getRegNo());
            vendor.setUser(createdUser);
            createdVendor = vendorRepository.save(vendor);

            this.vendorStoreIdImpl.generateAndSaveVendorStoreId(createdVendor.getId());
        }


        RegistrationResponse response = new RegistrationResponse();
        response.setId(createdUser.getId());
        response.setFirstName(createdUser.getFirstName());
        response.setLastName(createdUser.getLastName());
        response.setPhone(createdUser.getPhone());
        response.setEmail(createdUser.getEmail());
        response.setRoles(createdUser.getRoles());

        if (Roles.ADMIN.equals(createdUser.getRoles()) && createdAdmin != null) {
            AdminRegistrationResponse adminResponse = new AdminRegistrationResponse();
            adminResponse.setId(createdAdmin.getId());
            adminResponse.setIsActive(createdAdmin.getIsActive());
            response.setAdminRegistrationResponse(adminResponse);

        } else if (Roles.CUSTOMER.equals(createdUser.getRoles()) && createdCustomer != null) {
            CustomerRegistrationResponse customerResponse = new CustomerRegistrationResponse();
            customerResponse.setAddress(createdCustomer.getAddress());
            customerResponse.setLocation(createdCustomer.getLocation());
            response.setCustomerRegistrationResponse(customerResponse);

        } else if (Roles.VENDOR.equals(createdUser.getRoles())  && createdVendor != null) {
            VendorRegistrationResponse vendorResponse = new VendorRegistrationResponse();
            vendorResponse.setId(createdVendor.getId());
            vendorResponse.setCompanyName(createdVendor.getCompanyName());
            vendorResponse.setCompanyAddress(createdVendor.getCompanyAddress());
            vendorResponse.setLocation(createdVendor.getLocation());
            vendorResponse.setRegNo(createdVendor.getRegNo());
            response.setVendorRegistrationResponse(vendorResponse);
        }

        return  response;
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }

    @Override
    public User user(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));

    }

    @Override
    public User update(RegistrationRequest request){
        User user = getUserEmail(request.getEmail());

        if(user != null) {

            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setPhone(request.getPhone());
            user.setRoles(request.getRoles());

            User createdUser = userRepository.save(user);


            if(request.getRoles()== Roles.ADMIN){
                Admin admin = new Admin();
                admin.setIsActive(request.getAdminRegistrationRequest().getIsActive());
                admin.setUser(createdUser);
                adminRepository.save(admin);
            }
            if(request.getRoles() == Roles.CUSTOMER){
                Customer customer = new Customer();
                customer.setAddress(request.getCustomerRegistrationRequest().getAddress());
                customer.setLocation(request.getVendorRegistrationRequest().getLocation());
                customer.setUser(createdUser);
                customerRepository.save(customer);
            }
            if(request.getRoles() == Roles.VENDOR){
                Vendor vendor = new Vendor();
                vendor.setCompanyAddress(request.getVendorRegistrationRequest().getCompanyAddress());
                vendor.setCompanyAddress(request.getVendorRegistrationRequest().getCompanyAddress());
                vendor.setLocation(request.getVendorRegistrationRequest().getLocation());
                vendor.setUser(createdUser);
                vendorRepository.save(vendor);
            }
        }


        return user;

    }

    @Override
    public LoginResponse login(LoginRequest request) throws UserNotFoundException {
        User user = getUserEmail(request.getEmail());
        LoginResponse response;
        if(user != null){
            response = new LoginResponse();
            response.setId(user.getId());
            response.setFirstName(user.getFirstName());
            response.setEmail(user.getEmail());
            response.setLastName(user.getLastName());
            response.setPhone(user.getPhone());
            response.setRoles(user.getRoles());
            response.setMessage("Logged In successfully!");

        }else{
            throw new UserNotFoundException("User with " + request.getEmail() + "doesn't exist");
        }
        return response;
    }



}
