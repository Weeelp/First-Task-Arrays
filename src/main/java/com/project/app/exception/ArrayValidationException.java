package com.project.app.exception;

public class ArrayValidationException extends Exception {

  public ArrayValidationException(String e, Throwable cause) {
    super(e, cause);
  }

  public ArrayValidationException(Throwable cause) {
    super(cause);
  }

  public ArrayValidationException(String e) {
    super(e);
  }
}
