
// package org.smartapplication.services.Implementations;

// import lombok.AllArgsConstructor;
// import org.aspectj.weaver.ast.Var;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.smartapplication.dtos.response.Product.AddToStoreResponse;
// import org.smartapplication.dtos.response.Product.ProductResponse;
// import org.smartapplication.dtos.response.Vendor.StoreDTO;
// import org.smartapplication.dtos.response.Vendor.VendorResponse;
// import org.smartapplication.exceptions.ProductAlreadyAddedToStoreException;
// import org.smartapplication.exceptions.ProductNotFoundException;
// import org.smartapplication.exceptions.StoreNotFoundException;
// import org.smartapplication.exceptions.VendorNotFoundException;
// import org.smartapplication.model.Product;
// import org.smartapplication.model.Store;
// import org.smartapplication.model.Vendor;
// import org.smartapplication.repositories.ProductRepository;
// import org.smartapplication.repositories.StoreRepository;
// import org.smartapplication.repositories.VendorRepository;
// import org.smartapplication.repositories.VendorStoreIdRepository;
// import org.smartapplication.services.StoreService;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// @Service
// @AllArgsConstructor
// public class StoreServiceImpl implements StoreService {
//     private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

//     private final StoreRepository storeRepository;
//     private final ProductRepository productRepository;
//     private final VendorRepository vendorRepository;
//     private final VendorStoreIdRepository vendorStoreIdRepository;
//     @Override
//     public Store viewStore(String storeId) throws StoreNotFoundException {
//         Optional<Store> store = storeRepository.findByStoreId(storeId);

//         if(store.isPresent()){
//             return store.get();
//         }
//         throw new StoreNotFoundException("Store not found");
//     }

//     @Override
//     public List<Store> getAllProductsByVendorId(Long vendorId) {
//         return null;
//     }

//     @Override
//     public List<ProductResponse> getProductsByVendorId(Long vendorId) {
//         List<Long> productIds = storeRepository.findProductsByVendorId(vendorId);
//         return productIds.stream()
//                 .map(productRepository::findById)
//                 .filter(Optional::isPresent)
//                 .map(Optional::get)
//                 .map(this::convertToProductDTO)
//                 .collect(Collectors.toList());
//     }
//     private ProductResponse convertToProductDTO(Product product){
//         ProductResponse productDTO = new ProductResponse();
//         productDTO.setId(product.getId());
//         productDTO.setName(product.getName());
//         productDTO.setDescription(product.getDescription());
//         productDTO.setPrice(product.getPrice());
//         productDTO.setIsAvailable(product.getIsAvailable());
//         productDTO.setQuantity(product.getQuantity());
//         productDTO.setProductCategory(product.getProductCategory());
//         return productDTO;
//     }

//     @Override
//     public List<StoreDTO> getDistinctStoresByStoreId(String storeId) {
//         List<Store> stores = storeRepository.findDistinctByStoreId(storeId);
//         return stores.stream().map(this::convertToStoreDTO).collect(Collectors.toList());
//     }
//     @Override
//     public List<StoreDTO> getDistinctStoresByVendorId(Long vendorId) {
//         List<Store> stores = storeRepository.findDistinctbyVendorId(vendorId);
//         return stores.stream().map(this::convertToStoreDTO).collect(Collectors.toList());
//     }

//     @Override
//     public List<StoreDTO> getUniqueStores() {
//         List<Store> stores = storeRepository.findUniqueStores();
//         return stores.stream().map(this::convertToStoreDTO).collect(Collectors.toList());
//     }

//     private StoreDTO convertToStoreDTO(Store store) {
//         StoreDTO storeDTO = new StoreDTO();
//         storeDTO.setId(store.getId());
//         storeDTO.setStoreId(store.getStoreId());
//         storeDTO.setVendorId(store.getVendorId());
//         storeDTO.setProductId(store.getProductId());

//         Optional<Vendor> vendorOptional = vendorRepository.findById(store.getVendorId());
//         vendorOptional.ifPresent(vendor -> storeDTO.setVendor(convertToVendorDTO(vendor)));

//         Optional<Product> productOptional = productRepository.findById(store.getProductId());
//         productOptional.ifPresent(product -> storeDTO.setProduct(getProductPriceFromProductDTO(product)));

//         return storeDTO;
//     }

//     private ProductResponse getProductPriceFromProductDTO(Product product) {
//         ProductResponse productResponse = new ProductResponse();
//         productResponse.setPrice(product.getPrice());
//         return productResponse;
//     }

//     private VendorResponse convertToVendorDTO(Vendor vendor) {
//         VendorResponse vendorResponse = new VendorResponse();
//         vendorResponse.setId(vendor.getId());
//         vendorResponse.setCompanyName(vendor.getCompanyName());
//         vendorResponse.setCompanyAddress(vendor.getCompanyAddress());
//         vendorResponse.setRegistrationStatus(vendor.getRegistrationStatus());
//         vendorResponse.setLocation(vendor.getLocation());
//         vendorResponse.setRegNo(vendor.getRegNo());
//         return vendorResponse;
//     }


//     @Override
//     public AddToStoreResponse addProductToStore(Long productId, Long vendorId) throws VendorNotFoundException, ProductNotFoundException, ProductAlreadyAddedToStoreException {
//         var product = productRepository.findById(productId);
//         var vendor = vendorRepository.findById(vendorId);

//         if(product.isPresent() && vendor.isPresent()){
//             String storeId = this.vendorStoreIdRepository.findStoreIdByVendorId(vendorId);
//             logger.info("STORE ID", storeId);

//             Boolean productExists = storeRepository.existsByVendorIdAndStoreIdAndProductId(vendorId, storeId, productId);
//             if (productExists){
//                 throw new ProductAlreadyAddedToStoreException("You have already added this product to your store");
//             }else {
//                 Store store = new Store();
//                 store.setStoreId(storeId);
//                 store.setProductId(productId);
//                 store.setVendorId(vendorId);
//                 storeRepository.save(store);
//             }

//         }
//         return new AddToStoreResponse();
//     }

//     @Override
//     public void removeProductFromStore(Long productId, Long vendorId) {

//     }
// }