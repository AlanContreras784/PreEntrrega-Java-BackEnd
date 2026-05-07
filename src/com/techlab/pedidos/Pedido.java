package com.techlab.pedidos;

import java.util.ArrayList;

public class Pedido {

    private static int contadorId = 1;

    private int id;
    private ArrayList<LineaPedido> lineas;

    public Pedido(){
        this.id = contadorId++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea){
        lineas.add(linea);
    }
     public double calcularTotal(){

        double total = 0;

        for(LineaPedido linea : lineas){
            total += linea.calcularSubtotal();
        }

        return total;
    }

    public void mostrarPedido(){

        System.out.println("Pedido N° " + id);

            for(LineaPedido linea : lineas){
            System.out.println(
                    linea.getProducto().getNombre() +
                    " | Cantidad: " + linea.getCantidad() +
                    " | Subtotal: $" + linea.calcularSubtotal()
            );
        }

        System.out.println("TOTAL: $" + calcularTotal());
    }
}