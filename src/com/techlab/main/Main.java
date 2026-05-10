package com.techlab.main;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;
import com.techlab.pedidos.PedidoService;
import com.techlab.pedidos.LineaPedido;
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
            //System.out.println("6) Salir");
            System.out.println("6) Crear pedido");
            System.out.println("7) Listar pedidos");
            System.out.println("8) Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            System.out.println();
            scanner.nextLine();


            switch (opcion) {

                case 1:

                    try {

                        System.out.print("Nombre del producto: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        double precio = scanner.nextDouble();

                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();

                        Producto producto = new Producto(nombre, precio, stock);

                        productoService.agregarProducto(producto);

                        System.out.println("Producto agregado correctamente.");

                    } catch (Exception e) {

                        System.out.println("Error al ingresar datos.");
                        scanner.nextLine();
                    }

                    break;

                case 2:

                    productoService.listarProductos();

                    break;

                case 3:
            
                    System.out.print("Ingrese ID del producto: ");

                    String datoBuscar = scanner.nextLine();

                    Producto encontrado =
                            productoService.buscarPorId(datoBuscar);

                    if (encontrado != null) {

                        System.out.println(encontrado);

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:
                
                    System.out.print("Ingrese ID del producto: ");
                    String idActualizar = scanner.nextLine();

                    Producto productoActualizar =
                            productoService.buscarPorId(idActualizar);

                    if (productoActualizar != null) {

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();

                        System.out.print("Nuevo stock: ");
                        int nuevoStock = scanner.nextInt();

                        productoActualizar.setPrecio(nuevoPrecio);
                        productoActualizar.setStock(nuevoStock);

                        System.out.println("Producto actualizado.");

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Ingrese ID a eliminar: ");

                    String idEliminar = scanner.nextLine();

                    productoService.eliminarProducto(idEliminar);

                    break;

                case 6:

                        
                    ArrayList<LineaPedido> lineas =
                            new ArrayList<>();

                    String continuar;

                    do {
                    
                        System.out.print("Ingrese ID producto: "); // ... obtener datos del producto ...
                        String idProducto = scanner.nextLine();

                        Producto producto =
                                productoService.buscarPorId(idProducto);

                        if (producto == null) {

                            System.out.println("Producto no encontrado.");
                            break;
                        }

                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();

                        LineaPedido linea =
                                new LineaPedido(producto, cantidad);

                                lineas.add(linea);
                                
                        scanner.nextLine();

                        System.out.print("¿Agregar otro producto? (s/n): ");
                        continuar = scanner.nextLine(); // usuario escribe "s" o "n"

                    } while (continuar.equalsIgnoreCase("s")); // si escribió "s", se repite
                    
                    try {
                        
                        pedidoService.crearPedido(lineas);
                        
                    } catch (StockInsuficienteException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                 case 7:

                    pedidoService.listarPedidos();
                    
                    break;
                    
                 default:

                    System.out.println("Opción inválida.");
                }
                
    } while (opcion != 8);

    scanner.close();
    };
}