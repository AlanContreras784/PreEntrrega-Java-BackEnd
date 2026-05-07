package com.techlab.pedidos;
import com.techlab.productos.Producto;
import com.techlab.excepciones.StockInsuficienteException;
import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    // Crear pedido
    public void crearPedido(ArrayList<LineaPedido> lineas)
            throws StockInsuficienteException {

        Pedido pedido = new Pedido();

        // VALIDAR STOCK
        for (LineaPedido linea : lineas) {

            Producto producto = linea.getProducto();

            int cantidadSolicitada = linea.getCantidad();

            if (cantidadSolicitada > producto.getStock()) {

                throw new StockInsuficienteException(
                        "Stock insuficiente para el producto: "
                                + producto.getNombre()
                );
            }
        }

        // DESCONTAR STOCK Y AGREGAR LÍNEAS
        for (LineaPedido linea : lineas) {

            Producto producto = linea.getProducto();

            int nuevoStock =
                    producto.getStock() - linea.getCantidad();

            producto.setStock(nuevoStock);

            pedido.agregarLinea(linea);
        }

        pedidos.add(pedido);

        System.out.println("Pedido creado correctamente.");
        System.out.println("TOTAL: $" + pedido.calcularTotal());
    }

    // LISTAR PEDIDOS
    public void listarPedidos() {

        if (pedidos.isEmpty()) {

            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {

            pedido.mostrarPedido();

            System.out.println("--------------------------------");
        }
    }

    // OBTENER PEDIDOS
    public ArrayList<Pedido> getPedidos() {

        return pedidos;
    }
}
