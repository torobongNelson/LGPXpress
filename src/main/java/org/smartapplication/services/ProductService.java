package org.smartapplication.services;

import org.smartapplication.dtos.request.Product.AddProductRequest;
import org.smartapplication.dtos.request.Product.UpdateProductRequest;
import org.smartapplication.dtos.response.Product.AddProductResponse;
import org.smartapplication.dtos.response.Product.ProductResponse;
import org.smartapplication.dtos.response.Product.UpdateProductResponse;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.model.Product;

import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws Exception;
    ProductResponse getProductBy(Long id) throws ProductNotFoundException;
    List<ProductResponse> getVendorProducts(Long vendorId) throws Exception;
    ProductResponse getVendorProduct(Long vendorId) throws Exception;

    List<ProductResponse> getProducts(int page, int size);
    Product findById(Long id) throws ProductNotFoundException;
    UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) throws Exception;
}
