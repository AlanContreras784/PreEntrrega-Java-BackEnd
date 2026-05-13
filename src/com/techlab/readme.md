# Sistema de Gestión de Productos y Pedidos - TechLab

## 📌 Descripción

Aplicación de consola desarrollada en **Java** para la gestión de productos y pedidos.
El sistema permite administrar un inventario, realizar búsquedas, actualizar productos, eliminar registros y crear pedidos validando el stock disponible.

Este proyecto fue desarrollado aplicando conceptos de:

* Programación Orientada a Objetos (POO)
* Manejo de excepciones
* Colecciones (`ArrayList`)
* Validaciones reutilizables
* Arquitectura por capas simples
* Buenas prácticas de organización de código

---

# 🚀 Funcionalidades

## 📦 Gestión de Productos

* Agregar productos
* Listar productos
* Buscar productos por:

  * ID
  * Nombre
* Actualizar productos
* Eliminar productos

## 🛒 Gestión de Pedidos

* Crear pedidos con múltiples productos
* Validar stock disponible
* Descontar stock automáticamente
* Calcular total del pedido
* Listar pedidos realizados

## ✅ Validaciones

* Nombre obligatorio
* Precio no negativo
* Stock no negativo
* Manejo seguro de entrada por consola

---

# 📂 Estructura del Proyecto

```bash
com.techlab
│
├── excepciones
│   ├── ProductoNoEncontradoException.java
│   └── StockInsuficienteException.java
│
├── main
│   └── Main.java
│
├── pedidos
│   ├── LineaPedido.java
│   ├── Pedido.java
│   └── PedidoService.java
│
├── productos
│   ├── Producto.java
│   └── ProductoService.java
│
└── util
    └── Validador.java
```

---

# 🧠 Conceptos Aplicados

## 🔹 Programación Orientada a Objetos

Se utilizaron:

* Clases
* Objetos
* Encapsulamiento
* Constructores
* Métodos
* Sobrescritura de `toString()`

---

## 🔹 Excepciones Personalizadas

### `ProductoNoEncontradoException`

Se lanza cuando un producto no existe.

### `StockInsuficienteException`

Se utiliza cuando:

* El stock es insuficiente
* El stock ingresado es inválido

---

## 🔹 Validaciones Centralizadas

La clase `Validador` contiene métodos estáticos reutilizables para:

* Validar datos
* Leer enteros
* Leer doubles
* Leer texto

---

# ⚙️ Tecnologías Utilizadas

* Java
* Java Collections (`ArrayList`)
* Scanner
* Manejo de excepciones

---

# ▶️ Ejecución del Proyecto

## 1️⃣ Clonar repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

---

## 2️⃣ Abrir proyecto

Abrir el proyecto en:

* IntelliJ IDEA
* Eclipse
* VS Code

---

## 3️⃣ Ejecutar

Ejecutar la clase:

```bash
Main.java
```

Ubicación:

```bash
com.techlab.main.Main
```

---

# 📋 Menú del Sistema

```text
1) Agregar producto
2) Listar productos
3) Buscar producto
4) Actualizar producto
5) Eliminar producto
6) Crear pedido
7) Listar pedidos
8) Salir
```

---

# 📌 Ejemplo de Producto

```text
ID: 1 | Nombre: Mouse | Precio: $1500.0 | Stock: 10
```

---

# 📌 Ejemplo de Pedido

```text
Pedido N° 1

Mouse | Cantidad: 2 | Subtotal: $3000.0

TOTAL: $3000.0
```

---

# 🛠 Mejoras Futuras

* Persistencia en archivos o base de datos
* Interfaz gráfica
* Categorías de productos
* Login de usuarios
* Generación de facturas
* Base de datos MySQL
* API REST con Spring Boot

---

# 👨‍💻 Autor

Proyecto desarrollado por **Alan Contreras Flores** para práctica y aprendizaje de Java.
