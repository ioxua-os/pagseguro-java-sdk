package br.com.uol.pagseguro.api.exception;

import java.util.List;

public class ServerErrorsJSON implements ServerErrors {
    private List<ServerErrorJSON> errors;

    ServerErrorsJSON() {
    }

//    public void setErrors(List<ServerErrorJSON> errors) {
//        this.errors = errors;
//    }

    @Override
    public int size() {
        return null != errors ? errors.size() : 0;
    }

    @Override
    public ServerError getError(int code) {
        if (null == errors) return null;

        for (ServerErrorJSON error : errors) {
            if (error.getCode() == code) {
                return error;
            }
        }
        return null;
    }

    @Override
    public Iterable<? extends ServerError> getErrors() {
        return errors;
    }

    @Override
    public boolean contains(int code) {
        return getError(code) != null;
    }

    public static class ServerErrorJSON implements ServerError {
        private Integer code;
        private String message;

        ServerErrorJSON() {
        }

        @Override
        public Integer getCode() {
            return code;
        }

//        public void setCode(Integer code) {
//            this.code = code;
//        }

        @Override
        public String getMessage() {
            return message;
        }

//        public void setMessage(String message) {
//            this.message = message;
//        }

        @Override
        public String toString() {
            return "ServerErrorJSON [code=" + code + ", message=" + message + "]";
        }
    }
}
