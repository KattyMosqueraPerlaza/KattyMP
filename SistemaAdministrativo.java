package Main;
/**
 *
 * @author MOSPER
 */
import java.util.Scanner;
public class SistemaAdministrativo {
    public static Scanner sc = new Scanner(System.in);
    public static final int MAX_USUARIOS = 20;
    public static final int MAX_PRODUCTOS = 100;
    // USUARIOS
    public static String[] nombresUsuarios = new String[MAX_USUARIOS];
    public static String[] usuarios = new String[MAX_USUARIOS];
    public static String[] claves = new String[MAX_USUARIOS];
    public static int[] roles = new int[MAX_USUARIOS];
    public static int totalUsuarios = 0;
    public static int usuarioActivoIndex = -1;
    // DATOS POR USUARIO
    public static int[] cantidadProductos = new int[MAX_USUARIOS];
    public static String[][] prodNombre = new String[MAX_USUARIOS][MAX_PRODUCTOS];
    public static String[][] prodTipo = new String[MAX_USUARIOS][MAX_PRODUCTOS];
    public static String[][] prodUnidad = new String[MAX_USUARIOS][MAX_PRODUCTOS];
    public static double[][] prodStock = new double[MAX_USUARIOS][MAX_PRODUCTOS];
    public static double[][] prodCostoUnidad = new double[MAX_USUARIOS][MAX_PRODUCTOS];
    public static double[][] prodPrecioVenta = new double[MAX_USUARIOS][MAX_PRODUCTOS];
    // ventasMensuales[usuario][producto][mes]
    public static double[][][] ventasMensuales = new double[MAX_USUARIOS][MAX_PRODUCTOS][12];
    // Variables financieras por usuario
    public static double[] ingresosTotales = new double[MAX_USUARIOS];
    public static double[] costoVentasTotal = new double[MAX_USUARIOS];
    public static double[] gastosOperativos = new double[MAX_USUARIOS];
    // MÉTODO PRINCIPAL
    public static void main(String[] args) {
        inicializarUsuariosPorDefecto();
        cargarDatosPrueba(); 
        mostrarPresentacion();
        esperarTecla();
        boolean salirSistema = false;
        do {
            mostrarMenuInicio();
            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    int usuarioLogin = iniciarSesion();
                    if (usuarioLogin != -1) {
                        usuarioActivoIndex = usuarioLogin;
                        ejecutarSistemaUsuario();
                    }
                    break;
                case 2:
                    registrarUsuarioNuevo();
                    break;
                case 3:
                    salirSistema = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    esperarTecla();
                    break;
            }
        } while (!salirSistema);
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("          Gracias por utilizar el sistema administrativo");
        System.out.println("==============================================================");
    }
    // PRESENTACIÓN
    public static void mostrarPresentacion() {
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("        PROTOTIPO DE SISTEMA ADMINISTRATIVO");
        System.out.println("        INVENTARIO, COSTOS Y VENTAS");
        System.out.println("        EMPRENDIMIENTOS DE MACHALA");
        System.out.println("==============================================================");
    }
    // LECTURA SEGURA DE DATOS
    public static int leerEntero() {
        while (true) {
            try {
                String texto = sc.nextLine().trim();
                return Integer.parseInt(texto);
            } catch (Exception e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }
    public static double leerDouble() {
        while (true) {
            try {
                String texto = sc.nextLine().trim().replace(",", ".");
                return Double.parseDouble(texto);
            } catch (Exception e) {
                System.out.print("Ingrese un numero valido: ");
            }
        }
    }
    // NORMALIZAR TEXTO
    public static String normalizarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.trim().replaceAll("\\s+", " ").toUpperCase();
    }
    // MENÚ DE INICIO
    public static void mostrarMenuInicio() {
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("        PROTOTIPO DE SISTEMA ADMINISTRATIVO");
        System.out.println("        INVENTARIO, COSTOS Y VENTAS");
        System.out.println("==============================================================");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Registrar usuario nuevo");
        System.out.println("3. Salir");
        System.out.println("==============================================================");
        System.out.print("Seleccione una opcion: ");
    }
    // USUARIOS POR DEFECTO
    public static void inicializarUsuariosPorDefecto() {
        totalUsuarios = 2;
        // Usuario distribuidor/fabricante creado por defecto
        nombresUsuarios[0] = "Administrador Distribuidor";
        usuarios[0] = "admin";
        claves[0] = "1234";
        roles[0] = 1;
        // Usuario revendedor creado por defecto
        nombresUsuarios[1] = "Usuario Revendedor";
        usuarios[1] = "ventas";
        claves[1] = "5678";
        roles[1] = 2;
        // Inicialización de datos financieros
        for (int i = 0; i < totalUsuarios; i++) {
            cantidadProductos[i] = 0;
            ingresosTotales[i] = 0;
            costoVentasTotal[i] = 0;
            gastosOperativos[i] = 0;
        }
    }
    // REGISTRAR USUARIO NUEVO
    public static void registrarUsuarioNuevo() {
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                  REGISTRO DE USUARIO NUEVO");
        System.out.println("==============================================================");
        if (totalUsuarios >= MAX_USUARIOS) {
            System.out.println("ERROR: Se alcanzo el limite maximo de usuarios.");
            esperarTecla();
            return;
        }
        System.out.print("Nombre completo: ");
        String nombreCompleto = sc.nextLine().trim();
        System.out.print("Usuario: ");
        String nuevoUsuario = sc.nextLine().trim();
        System.out.print("Contraseña: ");
        String nuevaClave = sc.nextLine().trim();
        System.out.println("Tipo de negocio:");
        System.out.println("1. Distribuidor / Fabricante");
        System.out.println("2. Revendedor");
        System.out.print("Seleccione: ");
        int rol = leerEntero();
        if (nombreCompleto.isEmpty() || nuevoUsuario.isEmpty() || nuevaClave.isEmpty()) {
            System.out.println("ERROR: No se permiten campos vacios.");
            esperarTecla();
            return;
        }
        if (rol != 1 && rol != 2) {
            System.out.println("ERROR: Tipo de negocio invalido.");
            esperarTecla();
            return;
        }
        if (buscarUsuario(nuevoUsuario) != -1) {
            System.out.println("ERROR: Ese usuario ya existe.");
            esperarTecla();
            return;
        }
        int pos = totalUsuarios;
        nombresUsuarios[pos] = nombreCompleto;
        usuarios[pos] = nuevoUsuario;
        claves[pos] = nuevaClave;
        roles[pos] = rol;
        // El usuario nuevo empieza sin información
        cantidadProductos[pos] = 0;
        ingresosTotales[pos] = 0;
        costoVentasTotal[pos] = 0;
        gastosOperativos[pos] = 0;
        // Se limpia la matriz de ventas del usuario nuevo
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            for (int mes = 0; mes < 12; mes++) {
                ventasMensuales[pos][i][mes] = 0;
            }
        }
        totalUsuarios++;
        System.out.println("Usuario registrado correctamente.");
        System.out.println("Este usuario inicia sin productos, ventas ni gastos registrados.");
        System.out.println("Ahora ya puede iniciar sesion.");
        esperarTecla();
    }
    public static int buscarUsuario(String usuarioBuscado) {
        String buscado = normalizarTexto(usuarioBuscado);
        for (int i = 0; i < totalUsuarios; i++) {
            if (normalizarTexto(usuarios[i]).equals(buscado)) {
                return i;
            }
        }
        return -1;
    }
    public static int iniciarSesion() {
        limpiarPantalla();
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("==============================================================");
            System.out.println("                      INICIAR SESION");
            System.out.println("==============================================================");
            System.out.print("Usuario: ");
            String user = sc.nextLine().trim();
            System.out.print("Clave: ");
            String pass = sc.nextLine().trim();
            int posUsuario = buscarUsuario(user);
            if (posUsuario != -1 && claves[posUsuario].equals(pass)) {
                System.out.println("Acceso concedido. Bienvenido/a: " + nombresUsuarios[posUsuario]);
                esperarTecla();
                
                return posUsuario;
            }
            intentos--;
            System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
        }
        System.out.println("Se agotaron los intentos.");
        esperarTecla();
        return -1;
    }
    // SISTEMA POR USUARIO
    public static void ejecutarSistemaUsuario() {
        boolean salir = false;
        do {
            if (roles[usuarioActivoIndex] == 1) {
                mostrarMenuDistribuidor();
            } else {
                mostrarMenuRevendedor();
            }
            int opcion = leerEntero();
            if (roles[usuarioActivoIndex] == 1) {
                switch (opcion) {
                    case 1:
                        registrarProductoFabricado();
                        break;

                    case 2:
                        comprarProductoReventa();
                        break;

                    case 3:
                        registrarVenta();
                        break;

                    case 4:
                        registrarGasto();
                        break;

                    case 5:
                        mostrarInventario();
                        break;

                    case 6:
                        mostrarReporteFinanciero();
                        break;

                    case 7:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        esperarTecla();
                        break;
                }
            } else {
                switch (opcion) {
                    case 1:
                        comprarProductoReventa();
                        break;
                    case 2:
                        registrarVenta();
                        break;
                    case 3:
                        registrarGasto();
                        break;
                    case 4:
                        mostrarInventario();
                        break;
                    case 5:
                        mostrarReporteFinanciero();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        esperarTecla();
                        break;
                }
            }
        } while (!salir);
        usuarioActivoIndex = -1;
    }
    public static void mostrarMenuDistribuidor() {
        limpiarPantalla();
        System.out.println("Sesion activa: " + nombresUsuarios[usuarioActivoIndex]);
        System.out.println("Rol: Distribuidor / Fabricante");
        System.out.println("==============================================================");
        System.out.println("1. Registrar producto fabricado");
        System.out.println("2. Comprar producto terminado");
        System.out.println("3. Registrar venta");
        System.out.println("4. Registrar gasto operativo");
        System.out.println("5. Ver inventario");
        System.out.println("6. Ver reporte financiero");
        System.out.println("7. Cerrar sesion");
        System.out.println("==============================================================");
        System.out.print("Seleccione una opcion: ");
    }
    public static void mostrarMenuRevendedor() {
        limpiarPantalla();
        System.out.println("Sesion activa: " + nombresUsuarios[usuarioActivoIndex]);
        System.out.println("Rol: Revendedor");
        System.out.println("==============================================================");
        System.out.println("1. Comprar producto terminado");
        System.out.println("2. Registrar venta");
        System.out.println("3. Registrar gasto operativo");
        System.out.println("4. Ver inventario");
        System.out.println("5. Ver reporte financiero");
        System.out.println("6. Cerrar sesion");
        System.out.println("==============================================================");
        System.out.print("Seleccione una opcion: ");
    }
    // FUNCIONES MATEMÁTICAS
    public static double calcularUtilidad(double ingreso, double costo) {
        return ingreso - costo;
    }
    public static double calcularMargen(double utilidad, double ingreso) {
        if (ingreso > 0) {
            return (utilidad / ingreso) * 100;
        }
        return 0;
    }
    public static double calcularMargenProducto(double precioVenta, double costoUnidad) {
        if (precioVenta > 0) {
            return ((precioVenta - costoUnidad) / precioVenta) * 100;
        }
        return 0;
    }
    public static double calcularCostoPromedioPonderado(
            double stockActual,
            double costoActual,
            double stockNuevo,
            double costoNuevo) {
        double stockTotal = stockActual + stockNuevo;
        if (stockTotal == 0) {
            return 0;
        }
        return ((stockActual * costoActual) + (stockNuevo * costoNuevo)) / stockTotal;
    }
    public static double calcularValorInventario() {
        int u = usuarioActivoIndex;
        double valor = 0;
        for (int i = 0; i < cantidadProductos[u]; i++) {
            valor += prodStock[u][i] * prodCostoUnidad[u][i];
        }
        return valor;
    }
    // BÚSQUEDA DE PRODUCTOS
    public static int buscarProducto(String nombreBuscado) {
        int u = usuarioActivoIndex;
        String buscado = normalizarTexto(nombreBuscado);
        for (int i = 0; i < cantidadProductos[u]; i++) {
            if (normalizarTexto(prodNombre[u][i]).equals(buscado)) {
                return i;
            }
        }
        return -1;
    }
    // PRODUCCIÓN
    public static void registrarProductoFabricado() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("              REGISTRO DE PRODUCTO FABRICADO");
        System.out.println("==============================================================");
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Unidad de medida: ");
        String unidad = sc.nextLine().trim();
        System.out.print("Cantidad producida: ");
        double cantidad = leerDouble();
        System.out.print("Costo de materia prima: ");
        double costoMateriaPrima = leerDouble();
        System.out.print("Costo de mano de obra: ");
        double costoManoObra = leerDouble();
        System.out.print("Costo de empaque u otros directos: ");
        double costoEmpaque = leerDouble();
        System.out.print("Precio de venta sugerido por unidad: ");
        double precioVenta = leerDouble();
        boolean datosValidos = !nombre.isEmpty()&& !unidad.isEmpty() && cantidad > 0 && costoMateriaPrima >= 0 && costoManoObra >= 0
        && costoEmpaque >= 0 && precioVenta >= 0;
        if (!datosValidos) {
            System.out.println("ERROR: Datos inválidos.");
            esperarTecla();
            return;
        }
        double costoTotalLote = costoMateriaPrima + costoManoObra + costoEmpaque;
        double costoUnitarioNuevo = costoTotalLote / cantidad;
        int posicion = buscarProducto(nombre);
        if (posicion == -1) {
            if (cantidadProductos[u] < MAX_PRODUCTOS) {
                posicion = cantidadProductos[u];
                prodNombre[u][posicion] = nombre;
                prodTipo[u][posicion] = "Fabricado";
                prodUnidad[u][posicion] = unidad;
                prodStock[u][posicion] = cantidad;
                prodCostoUnidad[u][posicion] = costoUnitarioNuevo;
                prodPrecioVenta[u][posicion] = precioVenta;
                cantidadProductos[u]++;
                System.out.println("Producto fabricado registrado correctamente.");
            } else {
                System.out.println("ERROR: Limite maximo de productos alcanzado.");
            }
        } else {
            double stockAnterior = prodStock[u][posicion];
            double costoAnterior = prodCostoUnidad[u][posicion];
            if (Math.abs(costoUnitarioNuevo - costoAnterior) > 0.001) {
                System.out.println("AVISO CONTABLE:");
                System.out.printf("El producto ya existia con costo promedio anterior: $%.2f%n", costoAnterior);
                System.out.printf("El nuevo costo unitario de produccion es: $%.2f%n", costoUnitarioNuevo);
                System.out.println("El sistema actualizara el costo usando promedio ponderado.");
            }
            double nuevoCostoPromedio = calcularCostoPromedioPonderado(stockAnterior,costoAnterior,cantidad,costoUnitarioNuevo);
            prodStock[u][posicion] += cantidad;
            prodCostoUnidad[u][posicion] = nuevoCostoPromedio;
            prodPrecioVenta[u][posicion] = precioVenta;
            System.out.println("Producto existente actualizado correctamente.");
            System.out.printf("Nuevo costo promedio ponderado: $%.2f%n", nuevoCostoPromedio);
        }
        esperarTecla();
    }
    // COMPRAS
    public static void comprarProductoReventa() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("              COMPRA DE PRODUCTO TERMINADO");
        System.out.println("==============================================================");
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Unidad de medida: ");
        String unidad = sc.nextLine().trim();
        System.out.print("Cantidad comprada: ");
        double cantidad = leerDouble();
        System.out.print("Costo unitario de compra: ");
        double costoCompra = leerDouble();
        System.out.print("Precio de venta sugerido: ");
        double precioVenta = leerDouble();
        boolean datosValidos = !nombre.isEmpty() && !unidad.isEmpty() && cantidad > 0 && costoCompra >= 0 && precioVenta >= 0;
        if (!datosValidos) {
            System.out.println("ERROR: Datos invalidos.");
            esperarTecla();
            return;
        }
        int posicion = buscarProducto(nombre);
        if (posicion == -1) {
            if (cantidadProductos[u] < MAX_PRODUCTOS) {
                posicion = cantidadProductos[u];
                prodNombre[u][posicion] = nombre;
                prodTipo[u][posicion] = "Reventa";
                prodUnidad[u][posicion] = unidad;
                prodStock[u][posicion] = cantidad;
                prodCostoUnidad[u][posicion] = costoCompra;
                prodPrecioVenta[u][posicion] = precioVenta;
                cantidadProductos[u]++;
                System.out.println("Producto nuevo registrado correctamente.");
            } else {
                System.out.println("ERROR: Limite maximo de productos alcanzado.");
            }
        } else {
            double stockAnterior = prodStock[u][posicion];
            double costoAnterior = prodCostoUnidad[u][posicion];
            if (Math.abs(costoCompra - costoAnterior) > 0.001) {
                System.out.println("AVISO CONTABLE:");
                System.out.printf("El producto ya existia con costo promedio anterior: $%.2f%n", costoAnterior);
                System.out.printf("El nuevo costo de compra ingresado es: $%.2f%n", costoCompra);
                System.out.println("El sistema actualizara el costo usando promedio ponderado.");
            }
            double nuevoCostoPromedio = calcularCostoPromedioPonderado(
                    stockAnterior,
                    costoAnterior,
                    cantidad,
                    costoCompra
            );
            prodStock[u][posicion] += cantidad;
            prodCostoUnidad[u][posicion] = nuevoCostoPromedio;
            prodPrecioVenta[u][posicion] = precioVenta;
            System.out.println("Inventario actualizado correctamente.");
            System.out.printf("Nuevo costo promedio ponderado: $%.2f%n", nuevoCostoPromedio);
        }
        esperarTecla();
    }
    // VENTAS
    public static void registrarVenta() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                    REGISTRAR VENTA");
        System.out.println("==============================================================");
        if (cantidadProductos[u] == 0) {
            System.out.println("No existen productos registrados.");
            esperarTecla();
            return;
        }
        for (int i = 0; i < cantidadProductos[u]; i++) {
            System.out.printf("%d. %s | Stock: %.2f %s | Costo: $%.2f | Precio: $%.2f%n",
                    (i + 1),
                    prodNombre[u][i],
                    prodStock[u][i],
                    prodUnidad[u][i],
                    prodCostoUnidad[u][i],
                    prodPrecioVenta[u][i]);
        }
        System.out.print("Seleccione el numero del producto: ");
        int posicion = leerEntero() - 1;
        System.out.print("Cantidad vendida: ");
        double cantidad = leerDouble();
        System.out.print("Precio de venta cobrado: ");
        double precioVentaInput = leerDouble();
        System.out.print("Ingrese el mes de la venta (1-12): ");
        int mes = leerEntero();
        boolean datosValidos = posicion >= 0 && posicion < cantidadProductos[u] && cantidad > 0 && precioVentaInput >= 0 && mes >= 1 && mes <= 12;
        if (!datosValidos) {
            System.out.println("ERROR: Entrada de datos inválida.");
            esperarTecla();
            return;
        }
        if (prodStock[u][posicion] < cantidad) {
            System.out.println("ERROR: Stock insuficiente.");
            esperarTecla();
            return;
        }
        double ingresoVenta = cantidad * precioVentaInput;
        double costoVenta = cantidad * prodCostoUnidad[u][posicion];
        double utilidadVenta = calcularUtilidad(ingresoVenta, costoVenta);
        double margenVenta = calcularMargen(utilidadVenta, ingresoVenta);
        prodStock[u][posicion] -= cantidad;
        ingresosTotales[u] += ingresoVenta;
        costoVentasTotal[u] += costoVenta;
        ventasMensuales[u][posicion][mes - 1] += ingresoVenta;
        System.out.println("Venta registrada correctamente.");
        System.out.printf("Ingreso de la venta: $%.2f%n", ingresoVenta);
        System.out.printf("Costo de lo vendido: $%.2f%n", costoVenta);
        System.out.printf("Utilidad de la venta: $%.2f%n", utilidadVenta);
        System.out.printf("Margen de ganancia: %.2f%%%n", margenVenta);
        esperarTecla();
    }
    // GASTOS
    public static void registrarGasto() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                REGISTRAR GASTO OPERATIVO");
        System.out.println("==============================================================");
        System.out.print("Ingrese el valor del gasto: ");
        double gasto = leerDouble();
        if (gasto >= 0) {
            gastosOperativos[u] += gasto;
            System.out.println("Gasto registrado correctamente.");
        } else {
            System.out.println("ERROR: El gasto no puede ser negativo.");
        }
        esperarTecla();
    }
    // INVENTARIO
    public static void mostrarInventario() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                        INVENTARIO");
        System.out.println("==============================================================");
        if (cantidadProductos[u] == 0) {
            System.out.println("No hay productos registrados.");
        } else {
            for (int i = 0; i < cantidadProductos[u]; i++) {
                System.out.printf("%d. %s | Tipo: %s | Stock: %.2f %s | Costo promedio: $%.2f | Precio: $%.2f%n",
                        (i + 1),
                        prodNombre[u][i],
                        prodTipo[u][i],
                        prodStock[u][i],
                        prodUnidad[u][i],
                        prodCostoUnidad[u][i],
                        prodPrecioVenta[u][i]);
            }
        }
        esperarTecla();
    }
    // REPORTES
    public static void mostrarReporteFinanciero() {
        int u = usuarioActivoIndex;
        limpiarPantalla();
        double valorInventario = calcularValorInventario();
        double utilidadGeneral = ingresosTotales[u] - costoVentasTotal[u] - gastosOperativos[u];
        double margenGeneral = calcularMargen(utilidadGeneral, ingresosTotales[u]);
        System.out.println("==============================================================");
        System.out.println("                 REPORTE FINANCIERO GENERAL");
        System.out.println("==============================================================");
        System.out.printf("Ingresos totales:              $%.2f%n", ingresosTotales[u]);
        System.out.printf("Costo de ventas:               $%.2f%n", costoVentasTotal[u]);
        System.out.printf("Gastos operativos:             $%.2f%n", gastosOperativos[u]);
        System.out.printf("Valor total de inventario:     $%.2f%n", valorInventario);
        System.out.printf("Utilidad neta estimada:        $%.2f%n", utilidadGeneral);
        System.out.printf("Margen neto del negocio:       %.2f%%%n", margenGeneral);
        if (utilidadGeneral >= 0) {
            System.out.println("Estado: El negocio presenta ganancia estimada.");
        } else {
            System.out.println("Estado: El negocio presenta pérdida estimada.");
        }
        System.out.println();
        mostrarReporteVentasMensuales();
        System.out.println();
        generarRecomendaciones();
        
        esperarTecla();
    }
    public static void mostrarReporteVentasMensuales() {
        int u = usuarioActivoIndex;
        System.out.println("==============================================================");
        System.out.println("          REPORTE DE VENTAS MENSUALES");
        System.out.println("==============================================================");
        double mayorVentaMes = 0;
        int mesMayor = -1;
        for (int mes = 0; mes < 12; mes++) {
            double totalMes = 0;
            for (int i = 0; i < cantidadProductos[u]; i++) {
                totalMes += ventasMensuales[u][i][mes];
            }
            System.out.printf("Mes %d: $%.2f%n", (mes + 1), totalMes);
            if (totalMes > mayorVentaMes) {
                mayorVentaMes = totalMes;
                mesMayor = mes;
            }
        }
        if (mesMayor != -1 && mayorVentaMes > 0) {
            System.out.printf("Mes con mayores ventas: Mes %d con $%.2f%n", (mesMayor + 1), mayorVentaMes);
        } else {
            System.out.println("Aún no existen ventas registradas.");
        }
    }
    public static void generarRecomendaciones() {
        int u = usuarioActivoIndex;
        System.out.println("==============================================================");
        System.out.println("      RECOMENDACIONES PARA TOMA DE DECISIONES");
        System.out.println("==============================================================");
        boolean hayRecomendaciones = false;
        for (int i = 0; i < cantidadProductos[u]; i++) {
            if (prodStock[u][i] == 0) {
                System.out.println("ALERTA:");
                System.out.println("Producto: " + prodNombre[u][i]);
                System.out.println("Motivo: Producto agotado.");
                System.out.println("Recomendacion: Comprar o producir más unidades.");
                System.out.println("--------------------------------------------------------------");
                hayRecomendaciones = true;
            }
            if (prodStock[u][i] > 0 && prodStock[u][i] < 10) {
                System.out.println("RECOMENDACION:");
                System.out.println("Producto: " + prodNombre[u][i]);
                System.out.println("Motivo: Bajo inventario.");
                System.out.println("Stock actual: " + prodStock[u][i]);
                System.out.println("Stock minimo recomendado: 10");
                System.out.println("--------------------------------------------------------------");
                hayRecomendaciones = true;
            }
            if (prodPrecioVenta[u][i] <= prodCostoUnidad[u][i]) {
                System.out.println("ALERTA DE RENTABILIDAD:");
                System.out.println("Producto: " + prodNombre[u][i]);
                System.out.printf("Costo unitario: $%.2f%n", prodCostoUnidad[u][i]);
                System.out.printf("Precio actual: $%.2f%n", prodPrecioVenta[u][i]);
                System.out.println("Motivo: El producto no genera utilidad.");
                System.out.println("Recomendacion: Revisar el precio de venta.");
                System.out.println("--------------------------------------------------------------");
                hayRecomendaciones = true;
            } else {
                double margen = calcularMargenProducto(prodPrecioVenta[u][i], prodCostoUnidad[u][i]);
                if (margen < 15) {
                    System.out.println("RECOMENDACION POR BAJA RENTABILIDAD:");
                    System.out.println("Producto: " + prodNombre[u][i]);
                    System.out.printf("Costo unitario: $%.2f%n", prodCostoUnidad[u][i]);
                    System.out.printf("Precio actual: $%.2f%n", prodPrecioVenta[u][i]);
                    System.out.printf("Margen actual: %.2f%%%n", margen);
                    System.out.println("Motivo: margen menor al 15% recomendado.");
                    System.out.println("--------------------------------------------------------------");
                    hayRecomendaciones = true;
                }
            }
        }
        if (!hayRecomendaciones) {
            System.out.println("No se encontraron alertas importantes.");
        }
    }
    // DATOS DE PRUEBA
    public static void cargarDatosPrueba() {
        // Solo los usuarios creados por defecto tienen datos de prueba
        cargarProductosDemoParaUsuario(0); // admin - distribuidor
        cargarProductosDemoParaUsuario(1); // ventas - revendedor
    }
    public static void cargarProductosDemoParaUsuario(int u) {
        cantidadProductos[u] = 5;
        prodNombre[u][0] = "Arroz";
        prodTipo[u][0] = "Reventa";
        prodUnidad[u][0] = "unidad";
        prodStock[u][0] = 30;
        prodCostoUnidad[u][0] = 1.00;
        prodPrecioVenta[u][0] = 1.40;
        prodNombre[u][1] = "Azucar";
        prodTipo[u][1] = "Reventa";
        prodUnidad[u][1] = "unidad";
        prodStock[u][1] = 15;
        prodCostoUnidad[u][1] = 0.80;
        prodPrecioVenta[u][1] = 1.10;
        prodNombre[u][2] = "Cafe";
        prodTipo[u][2] = "Reventa";
        prodUnidad[u][2] = "unidad";
        prodStock[u][2] = 8;
        prodCostoUnidad[u][2] = 2.50;
        prodPrecioVenta[u][2] = 3.00;
        prodNombre[u][3] = "Jugo";
        prodTipo[u][3] = "Fabricado";
        prodUnidad[u][3] = "unidad";
        prodStock[u][3] = 0;
        prodCostoUnidad[u][3] = 0.50;
        prodPrecioVenta[u][3] = 0.90;
        prodNombre[u][4] = "Galletas";
        prodTipo[u][4] = "Reventa";
        prodUnidad[u][4] = "unidad";
        prodStock[u][4] = 12;
        prodCostoUnidad[u][4] = 0.50;
        prodPrecioVenta[u][4] = 0.55;
        // Ventas de prueba para demostrar la matriz mensual
        ventasMensuales[u][0][0] = 20.00; // Arroz mes 1
        ventasMensuales[u][1][0] = 12.00; // Azucar mes 1
        ventasMensuales[u][2][1] = 15.00; // Cafe mes 2
        ventasMensuales[u][3][2] = 18.00; // Jugo mes 3
        ingresosTotales[u] = 65.00;
        costoVentasTotal[u] = 42.50;
        gastosOperativos[u] = 10.00;
    }
    // MÉTODOS DE SOPORTE
    public static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
    public static void esperarTecla() {
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }
}