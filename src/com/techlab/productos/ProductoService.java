package com.techlab.productos;

import java.util.ArrayList;

import com.techlab.excepciones.ProductoNoEncontradoException;
//import com.techlab.pedidos.Pedido;
import com.techlab.util.Validador;

public class ProductoService {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto){
        Validador.validarNombre(producto.getNombre());
        Validador.validarPrecio(producto.getPrecio());
        Validador.validarStock(producto.getStock());
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

    public Producto buscarPorIdNombre(String dato){

        try {
            int id = Integer.parseInt(dato);
            for(Producto p : productos){
                if(p.getId() == id){
                    return p;
                }
            }
        } catch (NumberFormatException e) {
            // No es un número, buscar por nombre
            for(Producto p : productos){
                if(p.getNombre().equalsIgnoreCase(dato)){
                    return p;
                }
            }
        }
        throw new ProductoNoEncontradoException("Producto con ID o nombre '" + dato + "' no encontrado.");

    }

    public Producto actualizar(String datoBuscar, Producto datos) {
        // Reutilizamos obtenerPorId: si no existe, lanza excepción
        // y la actualización se cancela automáticamente.
        Producto p = buscarPorIdNombre(datoBuscar);

        // Validamos los nuevos datos antes de aplicarlos.
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        //Validador.validarCategoria(datos.getCategoria());

        // Modificamos el producto encontrado. Como Java pasa los
        // objetos por referencia, los cambios se reflejan en la
        // lista sin necesidad de hacer nada más.
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        //p.setCategoria(datos.getCategoria());

        return p;
    }




    public void eliminarProducto(String id){

        Producto producto = buscarPorIdNombre(id);

        if(producto != null){
            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
        throw new ProductoNoEncontradoException("Producto con ID o nombre '" + id + "' no encontrado.");
    }

    // OBTENER PRODUCTOS
    public ArrayList<Producto> getProductos() {

        return productos;
    }

    
} 