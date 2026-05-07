package com.techlab.main;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductoService productoService = new ProductoService();

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
            System.out.println("6) Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
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
                    int idBuscar = scanner.nextInt();

                    Producto encontrado =
                            productoService.buscarPorId(idBuscar);

                    if (encontrado != null) {

                        System.out.println(encontrado);

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Ingrese ID del producto: ");
                    int idActualizar = scanner.nextInt();

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

                    int idEliminar = scanner.nextInt();

                    productoService.eliminarProducto(idEliminar);

                    break;

                case 6:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}