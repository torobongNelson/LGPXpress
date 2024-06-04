package org.smartapplication.services.Implementations;

import org.smartapplication.dtos.request.Product.AddProductRequest;
import org.smartapplication.dtos.request.Product.UpdateProductRequest;
import org.smartapplication.dtos.response.Product.AddProductResponse;
import org.smartapplication.dtos.response.Product.ProductResponse;
import org.smartapplication.dtos.response.Product.UpdateProductResponse;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.Product;
import org.smartapplication.model.Vendor;
import org.smartapplication.repositories.ProductRepository;
import org.smartapplication.repositories.VendorRepository;
import org.smartapplication.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final VendorRepository vendorRepository;

    public ProductServiceImpl(ProductRepository productRepository,VendorRepository vendorRepository) {
        this.productRepository = productRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) throws Exception {
        Vendor vendor = vendorRepository.findById(request.getVendorId())
                .orElseThrow(() -> new Exception("Vendor not found"));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setProductCategory(request.getProductCategory());
        product.setVendor(vendor);

        Product addedProduct = productRepository.save(product);

        AddProductResponse response = new AddProductResponse();
        response.setId(addedProduct.getId());
        response.setName(addedProduct.getName());
        response.setPrice(addedProduct.getPrice());
        response.setDescription(addedProduct.getDescription());
        response.setQuantity(addedProduct.getQuantity());
        response.setProductCategory(addedProduct.getProductCategory());
        response.setVendorId(addedProduct.getVendor().getId());

        return response;
    }

    @Override
    public ProductResponse getProductBy(Long id) throws ProductNotFoundException {
        var product = productRepository.findById(id).orElseThrow(()->
                new ProductNotFoundException("product not found"));

        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setIsAvailable(product.getIsAvailable());
        response.setCreatedAt(product.getCreatedAt());

        return response;
    }

    @Override
    public List<ProductResponse> getVendorProducts(Long vendorId) throws Exception {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new Exception("There's no vendor with an Id of " + vendorId));

        if(vendor != null){
            List<Product> vendorProducts = productRepository.findByVendorId(vendorId);

            return  vendorProducts.stream()
                    .map(this::mapToProductResponse)
                    .toList();
        }else{
            throw new VendorNotFoundException("There's no vendor with an Id of " + vendorId);
        }

    }

    @Override
    public ProductResponse getVendorProduct(Long vendorId) throws Exception {
        var product = productRepository.findFirstByVendorId(vendorId);

        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setIsAvailable(product.getIsAvailable());
        response.setProductCategory(product.getProductCategory());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());

        return response;
    }

    @Override
    public List<ProductResponse> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        response.setProductCategory(product.getProductCategory());
        response.setQuantity(product.getQuantity());
        return response;
    }

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }else{
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) throws Exception {

        Product product = this.findById(request.getId());

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setIsAvailable(request.getIsAvailable());
        product.setProductCategory(request.getProductCategory());

        Product updatedProduct = productRepository.save(product);

        UpdateProductResponse response = new UpdateProductResponse();
        response.setId(updatedProduct.getId());
        response.setName(updatedProduct.getName());
        response.setPrice(updatedProduct.getPrice());
        response.setDescription(updatedProduct.getDescription());
        response.setQuantity(updatedProduct.getQuantity());
        response.setIsAvailable(updatedProduct.getIsAvailable());
        response.setProductCategory(updatedProduct.getProductCategory());

        return response;
    }

}
