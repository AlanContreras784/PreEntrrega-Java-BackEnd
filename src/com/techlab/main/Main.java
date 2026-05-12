package com.techlab.main;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;
import com.techlab.util.Validador;
import com.techlab.pedidos.PedidoService;
import com.techlab.pedidos.LineaPedido;
import com.techlab.excepciones.ProductoNoEncontradoException;
import com.techlab.excepciones.StockInsuficienteException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();

        int opcion;

        do {

            System.out.println("\n===================================");
            System.out.println(" SISTEMA DE GESTIÓN - TECHLAB ");
            System.out.println("===================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar producto");
            System.out.println("4) Actualizar producto");
            System.out.println("5) Eliminar producto");
            System.out.println("6) Crear pedido");
            System.out.println("7) Listar pedidos");
            System.out.println("8) Salir");
            
            opcion = Validador.leerEntero(scanner, "Elija una opción: ");
            


            switch (opcion) {

                case 1:

                    try {

                        String nombre = Validador.leerTexto(scanner, "Nombre del producto: ");                 
                        double precio = Validador.leerDouble(scanner, "Precio: ");
                        int stock = Validador.leerEntero(scanner, "Stock: ");
                        
                        Producto producto = new Producto(nombre, precio, stock);
                        
                        productoService.agregarProducto(producto);

                        System.out.println("Producto agregado correctamente.");

                    }catch (IllegalArgumentException | StockInsuficienteException e) {
                        // IllegalArgumentException es la que lanza el
                        // Validador para datos genéricos inválidos
                        // (nombre vacío, precio negativo, etc.).
                        System.out.println("Dato inválido: " + e.getMessage());
                    }

                    break;

                case 2:

                    productoService.listarProductos();

                    break;

                case 3:
                    try{
    
                        String datoBuscar = Validador.leerTexto(scanner, "Ingrese ID o nombre del producto: ");
    
                        Producto encontrado = productoService.buscarPorIdNombre(datoBuscar);
    
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } 
                         
                    } catch(ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }   

                    break;

                case 4:

                    try{

                        String productoBuscar = Validador.leerTexto(scanner, "Ingrese ID o nombre del producto: ");

                        Producto productoActual = productoService.buscarPorIdNombre(productoBuscar);

                        if (productoActual != null) {

                            System.out.println("Producto encontrado: " + productoActual);

                            double nuevoPrecio = Validador.leerDouble(scanner, "Nuevo precio: ");
                            int nuevoStock = Validador.leerEntero(scanner, "Nuevo stock: ");

                            Producto datosActualizados = new Producto (productoActual.getNombre(),nuevoPrecio, nuevoStock);
                            Producto actualizado = productoService.actualizar(productoBuscar, datosActualizados);
                            System.out.println("Producto actualizado." + actualizado);

                        } 
                    }catch(ProductoNoEncontradoException | StockInsuficienteException e) {
                        System.out.println(e.getMessage());

                    } catch (IllegalArgumentException e) {
                        System.out.println("Dato inválido: " + e.getMessage());
                    }

                    break;

                case 5:

                    String continuarEliminar;

                    do{
                        
                        try{

                            String continuarConfirmar;

                            String idEliminar = Validador.leerTexto(scanner, "Ingrese ID o Nombre del producto a eliminar: ");
    
                            continuarConfirmar = Validador.leerTexto(scanner, "¿Confirma que desea eliminar el producto " +idEliminar.toString() +" ?(s/n): ");
                            if(continuarConfirmar.equalsIgnoreCase("s")){
                                productoService.eliminarProducto(idEliminar);
                            }   
                        } catch (ProductoNoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        continuarEliminar = Validador.leerTexto(scanner, "¿Desea eliminar otro producto? (s/n): ");
                        
                    } while (continuarEliminar.equalsIgnoreCase("s"));

                    break;

                case 6:
                        
                    ArrayList<LineaPedido> lineas = new ArrayList<>();

                    String continuar;

                    do {
                        // ... obtener datos del producto ...
                        String idProducto = Validador.leerTexto(scanner, "Ingrese ID ó Nombre del producto: ");

                        Producto producto = productoService.buscarPorIdNombre(idProducto);
                        // Verifica si el producto existe
                        if (producto == null) {

                            System.out.println("Producto no encontrado.");
                            System.out.print("¿Desea seguir agregando productos al pedido? (s/n): ");

                            continuar = scanner.nextLine();// usuario escribe "s" o "n"

                            // vuelve al inicio del ciclo
                            continue;
                        }

                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();

                        LineaPedido linea = new LineaPedido(producto, cantidad);

                        lineas.add(linea);
                                
                        scanner.nextLine();

                        System.out.print("¿Agregar otro producto? (s/n): ");
                        continuar = scanner.nextLine(); // usuario escribe "s" o "n"

                    } while (continuar.equalsIgnoreCase("s")); // si escribió "s", se repite
                    
                    // Verifica que exista al menos un producto en el pedido antes de intentar crearlo
                    if (lineas.isEmpty()) {

                        System.out.println("No se creó el pedido porque no se agregaron productos.");
                        break;
                    }
                    // Intenta crear el pedido con las líneas ingresadas
                    try {
                        
                        pedidoService.crearPedido(lineas);
                        
                    } catch (StockInsuficienteException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                 case 7:

                    pedidoService.listarPedidos();
                    
                    break;

                 case 8:

                    System.out.println("Saliendo del programa...");
                    
                    break;
                    
                 default:

                    System.out.println("Opción inválida.");
                }
                
    } while (opcion != 8);

    scanner.close();
    };
}