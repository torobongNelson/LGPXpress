package org.smartapplication.services.Implementations;

import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.exceptions.StoreNotFoundException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.Store;
import org.smartapplication.repositories.ProductRepository;
import org.smartapplication.repositories.StoreRepository;
import org.smartapplication.repositories.VendorRepository;
import org.smartapplication.repositories.VendorStoreIdRepository;
import org.smartapplication.services.StoreService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
   private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

   private final StoreRepository storeRepository;
   private final ProductRepository productRepository;
   private final VendorRepository vendorRepository;
   private final VendorStoreIdRepository vendorStoreIdRepository;

   public StoreServiceImpl(StoreRepository storeRepository, ProductRepository productRepository, VendorRepository vendorRepository, VendorStoreIdRepository vendorStoreIdRepository) {
      this.storeRepository = storeRepository;
      this.productRepository = productRepository;
      this.vendorRepository = vendorRepository;
      this.vendorStoreIdRepository = vendorStoreIdRepository;
   }


   /** Method provides functionality to view a store
    * @param storeId
    * @return
    */
   @Override
   public Store viewStore(String storeId) throws StoreNotFoundException {
      Optional<Store> store = storeRepository.findByStoreId(storeId);

      if(store.isPresent()){
         return store.get();
      }
      throw new StoreNotFoundException("Store not found");
   }

   /**
    * @param productId
    * @param vendorId
    */
   @Override
   public void addProductToStore(Long productId, Long vendorId) throws VendorNotFoundException, ProductNotFoundException {
      var product = productRepository.findById(productId);
      var vendor = vendorRepository.findById(vendorId);

      if(product.isPresent() && vendor.isPresent()) {
         String storeId = this.vendorStoreIdRepository.findStoreIdByVendorId(vendorId);
         logger.info("STORE ID", storeId);

         var store = new Store();
         store.setStoreId(storeId);
         store.setProductId(productId);
         store.setVendorId(vendorId);
         storeRepository.save(store);
         logger.info("Store entity saved: {}", store);
      }
   }

   /** Gives a vendor the ability to remove a product from the store
    * @param productId
    * @param vendorId
    */
   @Override
   public void removeProductFromStore(Long productId, Long vendorId) {
      // later in life
   }

}
