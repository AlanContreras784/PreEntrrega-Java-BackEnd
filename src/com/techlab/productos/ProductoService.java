package com.techlab.productos;

import java.util.ArrayList;

public class ProductoService {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void listarProductos(){

        if(productos.isEmpty()){
            System.out.println("No hay productos registrados.");
            return;
        }
        for(Producto p : productos){
            System.out.println(p);
        }
    }

    public Producto buscarPorId(int id){

        for(Producto p : productos){
            if(p.getId() == id){
                return p;
            }
        }

        return null;
    }
    public void eliminarProducto(int id){

        Producto producto = buscarPorId(id);

        if(producto != null){
            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
} 