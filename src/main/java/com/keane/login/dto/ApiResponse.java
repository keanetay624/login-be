package com.keane.login.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private Object data;
    private String errorMsg;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpStatus = builder.httpStatus;
        this.data = builder.data;
        this.errorMsg = builder.errorMsg;
    }

    // Builder class
    public static class ApiResponseBuilder {
        // required parameters
        private final HttpStatus httpStatus;

        // optional parameters
        private Object data;
        private String errorMsg;

        public ApiResponseBuilder(HttpStatus httpStatus){
            this.httpStatus=httpStatus;
        }

        public ApiResponse.ApiResponseBuilder setData(Object data) {
            this.data = data;
            return this;
        }

        public ApiResponse.ApiResponseBuilder setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public ApiResponse build(){
            return new ApiResponse(this);
        }
    }
}
