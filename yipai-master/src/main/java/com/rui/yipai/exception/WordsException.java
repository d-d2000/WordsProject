package com.rui.yipai.exception;

public class WordsException extends RuntimeException{
        private static final String err = "系统异常！";

    public WordsException(String errMsg) {
        super(errMsg.isEmpty() ? err : errMsg);
        }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
