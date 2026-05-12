package com.techlab.excepciones;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(String mensaje) {
        // super() llama al constructor de la clase padre (RuntimeException),
        // que es quien guarda el mensaje y lo expone con getMessage().
        super(mensaje);
    }
}