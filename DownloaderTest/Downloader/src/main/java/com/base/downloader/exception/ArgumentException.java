package com.base.downloader.exception;

/**
 * 参数异常
 */

public class ArgumentException extends RuntimeException{
    public ArgumentException(){
        super();
    }

    public ArgumentException(String s){
        super(s);
    }
}
