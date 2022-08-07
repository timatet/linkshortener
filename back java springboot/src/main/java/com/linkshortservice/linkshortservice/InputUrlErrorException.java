package com.linkshortservice.linkshortservice;

public class InputUrlErrorException extends Exception {
    public InputUrlErrorException() { super(); }
    public InputUrlErrorException(String message) { super(message); }
    public InputUrlErrorException(String message, Throwable cause) { super(message, cause); }
    public InputUrlErrorException(Throwable cause) { super(cause); }
  }
