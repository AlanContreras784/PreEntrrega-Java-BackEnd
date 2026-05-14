package com.techlab.productos;

public class Producto {
    //ATRIBUTOS
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    //CONSTRUCTOR
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    //GETTERS
    public int getId() { return id;}
    public String getNombre() { return nombre;}
    public double getPrecio() { return precio;}
    public int getStock() { return stock;}
    //SETTERS
    public void setId(int id) { this.id = id;}   
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setPrecio(double precio) { this.precio = precio;}
    public void setStock(int stock) { this.stock = stock;}

    @Override
    public String toString() {
        return "ID: " + id +" | Nombre: " + nombre +" | Precio: $" + precio +" | Stock: " + stock;
    }
}
