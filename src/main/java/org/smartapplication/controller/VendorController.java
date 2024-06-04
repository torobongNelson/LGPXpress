package org.smartapplication.controller;

import org.smartapplication.dtos.request.Product.AddProductRequest;
import org.smartapplication.dtos.request.Product.UpdateProductRequest;
import org.smartapplication.dtos.request.Vendor.AddToStoreRequest;
import org.smartapplication.dtos.response.Product.AddProductResponse;
import org.smartapplication.dtos.response.Product.ProductResponse;
import org.smartapplication.dtos.response.Product.UpdateProductResponse;
import org.smartapplication.exceptions.ProductAlreadyAddedToStoreException;
import org.smartapplication.exceptions.VendorNotFoundException;
import org.smartapplication.model.Product;
import org.smartapplication.services.Implementations.ProductServiceImpl;
import org.smartapplication.services.Implementations.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/product")
public class VendorController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private StoreServiceImpl storeService;


    public VendorController(ProductServiceImpl productService, StoreServiceImpl storeService) {
        this.productService = productService;
        this.storeService = storeService;
    }
    

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> products(@RequestParam int page, int size){
        var allProducts = productService.getProducts(page, size);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/vendor-products/{vendorId}")
    public ResponseEntity<List<ProductResponse>> vendorProducts(@PathVariable Long vendorId) throws Exception {
        var allProducts = productService.getVendorProducts(vendorId);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping("/add/{vendorId}")
    public ResponseEntity<AddProductResponse> addProduct(@PathVariable("vendorId") Long vendorId, @RequestBody AddProductRequest request ) throws Exception {
        var addedProduct = productService.addProduct( request);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> product(@PathVariable Long id){
        var product =  productService.findById(id);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<UpdateProductResponse> updateProduct(@RequestBody UpdateProductRequest request )
            throws Exception {
        var updatedProduct = productService.updateProduct(request);
        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }


    @PostMapping("/add-to-store")
    public ResponseEntity addToStore(@RequestBody AddToStoreRequest request) throws ProductAlreadyAddedToStoreException {
        try {
            storeService.addProductToStore(request.getProductId(), request.getVendorId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (VendorNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
