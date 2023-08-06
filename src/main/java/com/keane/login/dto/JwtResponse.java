package com.keane.login.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JwtResponse {
    private HttpStatus httpStatus;
    private String accToken;
    private String errorMsg;

    private JwtResponse(JwtResponseBuilder builder) {
        this.httpStatus = builder.httpStatus;
        this.accToken = builder.accToken;
        this.errorMsg = builder.errorMsg;
    }

    // Builder class
    public static class JwtResponseBuilder {
        // required parameters
        private final HttpStatus httpStatus;

        // optional parameters
        private String accToken;
        private String errorMsg;

        public JwtResponseBuilder(HttpStatus httpStatus){
            this.httpStatus=httpStatus;
        }

        public JwtResponseBuilder setAccToken(String accToken) {
            this.accToken = accToken;
            return this;
        }

        public JwtResponseBuilder setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public JwtResponse build(){
            return new JwtResponse(this);
        }
    }

}
