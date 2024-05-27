package org.smartapplication.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<U> {
//    private boolean isSuccessful;
    private Object data;
}
