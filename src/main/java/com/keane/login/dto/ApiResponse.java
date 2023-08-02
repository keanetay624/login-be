package com.keane.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private String accToken;
    private String errorMsg;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpStatus = builder.httpStatus;
        this.accToken = builder.accToken;
        this.errorMsg = builder.errorMsg;
    }

    // Builder class
    public static class ApiResponseBuilder {
        // required parameters
        private final HttpStatus httpStatus;

        // optional parameters
        private String accToken;
        private String errorMsg;

        public ApiResponseBuilder(HttpStatus httpStatus){
            this.httpStatus=httpStatus;
        }

        public ApiResponseBuilder setAccToken(String accToken) {
            this.accToken = accToken;
            return this;
        }

        public ApiResponseBuilder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public ApiResponse build(){
            return new ApiResponse(this);
        }
    }

}
