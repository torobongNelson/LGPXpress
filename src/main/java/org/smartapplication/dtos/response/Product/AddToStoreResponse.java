package org.smartapplication.dtos.response.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToStoreResponse {
    private String message;
    public AddToStoreResponse(){
        this.message = "Product added to store successfully";
    }
}
