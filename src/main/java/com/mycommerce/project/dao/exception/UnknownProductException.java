
package com.mycommerce.project.dao.exception;

public class UnknownProductException extends RuntimeException {

    public UnknownProductException(Long id) {
        super("The product with id=" + id + " doesn't exist.");
    }
}
