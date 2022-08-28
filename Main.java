//  Comentario 1- Rol: Administrador de BD
// Comentario 2 - Rol : Analista
// Comentario 3 - Rol: Desarrollador
// Comentario 4 - Rol: Product owner
package Control;
import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Empresa> dataEmpresa = new ArrayList<Empresa>();
    private static ArrayList<Empleado> dataEmpleado = new ArrayList<Empleado>();
    private static ArrayList<MovimientoDinero> dataMovimientos = new ArrayList<MovimientoDinero>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        agregarDatosEmpresa();
        agregarDatosEmpleado();
        agregarDatosMovimientos();
        menuPrincipal();
    }

    //  MENU PRINCIPAL -----------------------------------------------------------------------------------

    private static void menuPrincipal() {
        while (true) {
            imprimirMenuPrincipal();
            int opcion = leerOpcionPrincipal();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuEmpresas();
                    break;
                case 2:
                    menuEmpleados();
                    break;
                case 3:
                    menuMovimientosDinero();
                    break;

            }

        }
    }
    private static void imprimirMenuPrincipal() {

        System.out.println("=== MENU ===");
        System.out.println("0. para salir");
        System.out.println("1. para empresas");
        System.out.println("2. para empleados ");
        System.out.println("3. para transacciones");
    }
    private static int leerOpcionPrincipal() {
        System.out.println("Introduce opcion: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        while (opcion < 0 || opcion > 3) {
            System.out.println("Error...introduce opcion nuevamente:");
            opcion = Integer.parseInt(scanner.nextLine());
        }
        return opcion;
    }

    //  EMPRESAS -------------------------------------------------------------------------------------

    private static void menuEmpresas(){
        while (true) {
            imprimirMenuEmpresas();
            int opcion = leerOpcionEmpresas();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cargarNuevaEmpresa();
                    break;
                case 2:
                    imprimirEmpresas();
                    break;
                case 3:
                    System.out.println("Ingresar nombre a modificar:");
                    String nombre = scanner.nextLine();
                    modificarNombreEmpresa(nombre);
                    break;
                case 4:
                    System.out.println("Ingresar nombre de empresa a la cual quiere modificar la direccion:");
                    String nombreDir = scanner.nextLine();
                    modificarDireccion(nombreDir);
                    break;
                case 5:
                    System.out.println("Ingresar nombre de empresa a la cual quiere modificar el telefono:");
                    String nombreTel = scanner.nextLine();
                    modificarTelefono(nombreTel);
                    break;
                case 6:
                    System.out.println("Ingresar nombre de empresa a la cual quiere modificar el NIT:");
                    String nombreNit = scanner.nextLine();
                    modificarNit(nombreNit);
                    break;
                case 7:
                    menuPrincipal();
                    break;
            }

        }
    }
    private static void imprimirMenuEmpresas() {

        System.out.println("=== MENU EMPRESAS ===");
        System.out.println("0. para salir");
        System.out.println("1. para cargar datos de una empresa");
        System.out.println("2. para ver empresas registradas ");
        System.out.println("3. para modificar el nombre de una empresa");
        System.out.println("4. para modificar la direccion de una empresa ");
        System.out.println("5. para modificar el telefono de una empresa");
        System.out.println("6. para modificar el NIT de una empresa");
        System.out.println("7. para volver al menu principal");

    }
    private static int leerOpcionEmpresas() {
        System.out.println("Introduce opcion: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        while (opcion < 0 || opcion > 7) {
            System.out.println("Error...introduce opcion nuevamente:");
            opcion = Integer.parseInt(scanner.nextLine());
        }
        return opcion;
    }
    public static void addEmpresa(Empresa empresa) {
        dataEmpresa.add(empresa);
    }
    private static void cargarNuevaEmpresa() {
        Empresa empresa = null;
        System.out.println("=== CARGAR DATOS EMPRESA ===");

        System.out.println("Ingresar nombre empresa: ");
        String nombre = scanner.nextLine();
        while (nombre.isBlank()) {
            System.out.println("Error...ingresar nombre empresa: ");
            nombre = scanner.nextLine();
        }

        System.out.println("Ingresar direccion empresa: ");
        String direccion = scanner.nextLine();
        while (direccion.isBlank()) {
            System.out.println("Error...ingrasar direccion empresa: ");
            direccion = scanner.nextLine();
        }

        System.out.println("Ingresar telefono empresa: ");
        String telefono = scanner.nextLine();
        while (telefono.isBlank()) {
            System.out.println("Error...ingrasar telefono empresa: ");
            telefono = scanner.nextLine();
        }

        System.out.println("Ingresar NIT empresa: ");
        String nit = scanner.nextLine();
        while (nit.isBlank()) {
            System.out.println("Error...ingrasar NIT empresa: ");
            nit = scanner.nextLine();
        }
        empresa = new Empresa(nombre,direccion,telefono,nit);
        addEmpresa(empresa);
    }
    private static void imprimirEmpresas() {
        System.out.println("=== EMPRESAS EXISTENTES ===");
        for (Empresa empresa : dataEmpresa) {
            System.out.println(empresa);
        }
    }
    private static void modificarNombreEmpresa(String nombre) {
        for (Empresa e : dataEmpresa) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(e);
                System.out.println("Nuevo nombre empresa: ");
                String nombreNuevo = scanner.nextLine();
                e.setNombre(nombreNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empresa no encontrada");
    }
    private static void modificarDireccion(String nombreDir) {
        for (Empresa e : dataEmpresa) {
            if (e.getNombre().equalsIgnoreCase(nombreDir)) {
                System.out.println(e);
                System.out.println("Nueva direccion empresa: ");
                String direccionNueva = scanner.nextLine();
                e.setDireccion(direccionNueva);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empresa no encontrada");
    }
    private static void modificarTelefono(String nombreTel) {
        for (Empresa e : dataEmpresa) {
            if (e.getNombre().equalsIgnoreCase(nombreTel)) {
                System.out.println(e);
                System.out.println("Nuevo telefono empresa: ");
                String telefonoNuevo = scanner.nextLine();
                e.setTelefono(telefonoNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empresa no encontrada");
    }
    private static void modificarNit(String nombreNit) {
        for (Empresa e : dataEmpresa) {
            if (e.getNombre().equalsIgnoreCase(nombreNit)) {
                System.out.println(e);
                System.out.println("Nuevo NIT empresa: ");
                String nitNuevo = scanner.nextLine();
                e.setNit(nitNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empresa no encontrada");
    }


    // EMPLEADOS -------------------------------------------------------------------------------------

    private static void menuEmpleados(){
        while (true) {
            imprimirMenuEmpleados();
            int opcion = leerOpcionEmpleados();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cargarNuevoEmpleado();
                    break;
                case 2:
                    imprimirEmpleados();
                    break;
                case 3:
                    System.out.println("Ingresar nombre de empleado a modificar:");
                    String nombre = scanner.nextLine();
                    modificarNombreEmpleado(nombre);
                    break;
                case 4:
                    System.out.println("Ingresar nombre de empleado a modificar el correo:");
                    String nombreCorreo = scanner.nextLine();
                    modificarCorreoEmpleado(nombreCorreo);
                    break;
                case 5:
                    System.out.println("Ingresar nombre de empleado a modificar la empresa:");
                    String nombreEmpresa = scanner.nextLine();
                    modificarEmpresaEmpleado(nombreEmpresa);
                    break;
                case 6:
                    System.out.println("Ingresar nombre de empleado a modificar el rol:");
                    String nombreRol = scanner.nextLine();
                    modificarRolEmpleado(nombreRol);
                    break;
                case 7:
                    menuPrincipal();
                    break;

            }

        }
    }
    private static void imprimirMenuEmpleados() {

        System.out.println("=== MENU EMPLEADOS ===");
        System.out.println("0. para salir");
        System.out.println("1. para cargar datos de una empleado");
        System.out.println("2. para ver empleados registrados");
        System.out.println("3. para modificar el nombre de un empleado");
        System.out.println("4. para modificar el correo de un empleado");
        System.out.println("5. para modificar la empresa a la que pertenece un empleado");
        System.out.println("6. para modificar el rol de un empleado");
        System.out.println("7. para volver al menu principal");

    }
    private static int leerOpcionEmpleados() {
        System.out.println("Introduce opcion: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        while (opcion < 0 || opcion > 7) {
            System.out.println("Error...introduce opcion nuevamente:");
            opcion = Integer.parseInt(scanner.nextLine());
        }
        return opcion;
    }
    public static void addEmpleado(Empleado empleado) {
        dataEmpleado.add(empleado);
    }
    private static void cargarNuevoEmpleado() {
        Empleado empleado = null;
        System.out.println("=== CARGAR DATOS EMPLEADO ===");

        System.out.println("Ingresar nombre empleado: ");
        String nombre = scanner.nextLine();
        while (nombre.isBlank()) {
            System.out.println("Error...ingresar nombre empleado: ");
            nombre = scanner.nextLine();
        }

        System.out.println("Ingresar correo empleado: ");
        String correo = scanner.nextLine();
        while (correo.isBlank()) {
            System.out.println("Error...ingresar correo empleado: ");
            correo = scanner.nextLine();
        }

        System.out.println("Ingresar empresa a la que pertenece el empleado: ");
        String empresaEmpleado = scanner.nextLine();
        while (empresaEmpleado.isBlank()) {
            System.out.println("Error...ingresar empresa a la que pertenece el empleado: ");
            empresaEmpleado = scanner.nextLine();
        }

        System.out.println("Ingresar rol del empleado: ");
        String rol = scanner.nextLine();
        while (rol.isBlank()) {
            System.out.println("Error...ingresar rol del empleado: ");
            rol = scanner.nextLine();
        }
        empleado = new Empleado(nombre,correo,empresaEmpleado,rol);
        addEmpleado(empleado);
    }
    private static void imprimirEmpleados() {
        System.out.println("=== EMPLEADOS EXISTENTES ===");
        for (Empleado empleado : dataEmpleado) {
            System.out.println(empleado);
        }
    }
    private static void modificarNombreEmpleado(String nombre) {
        for (Empleado e : dataEmpleado) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(e);
                System.out.println("Nuevo nombre empleado: ");
                String nombreNuevo = scanner.nextLine();
                e.setNombre(nombreNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empleado no encontrado");
    }
    private static void modificarCorreoEmpleado(String nombreCorreo) {
        for (Empleado e : dataEmpleado) {
            if (e.getNombre().equalsIgnoreCase(nombreCorreo)) {
                System.out.println(e);
                System.out.println("Nuevo correo empleado: ");
                String correoNuevo = scanner.nextLine();
                e.setCorreo(correoNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empleado no encontrado");
    }
    private static void modificarEmpresaEmpleado(String nombreEmpresa) {
        for (Empleado e : dataEmpleado) {
            if (e.getNombre().equalsIgnoreCase(nombreEmpresa)) {
                System.out.println(e);
                System.out.println("Nueva empresa empleado: ");
                String empresaNueva = scanner.nextLine();
                e.setEmpresa(empresaNueva);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empleado no encontrado");
    }
    private static void modificarRolEmpleado(String nombreRol) {
        for (Empleado e : dataEmpleado) {
            if (e.getNombre().equalsIgnoreCase(nombreRol)) {
                System.out.println(e);
                System.out.println("Nuevo rol empleado: ");
                String rolNuevo = scanner.nextLine();
                e.setRol(rolNuevo);
                System.out.println(e);
                break;
            }
        }
        System.out.println("Empleado no encontrado");
    }

    //  MOVIMIENTOS -------------------------------------------------------------------------------------

    private static void menuMovimientosDinero(){
        while (true) {
            imprimirMenuMovimientosDinero();
            int opcion = leerOpcionMovimientosDinero();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cargarNuevoMovimiento();
                    break;
                case 2:
                    imprimirMovimientos();
                    break;
                case 3:
                    System.out.println("Ingresar nombre de usuario a modificar el monto:");
                    String nombreMonto = scanner.nextLine();
                    modificarMonto(nombreMonto);
                    break;
                case 4:
                    System.out.println("Ingresar nombre de usuario a modificar el concepto del movimiento:");
                    String nombreConcepto = scanner.nextLine();
                    modificarConcepto(nombreConcepto);
                    break;
                case 5:
                    menuPrincipal();
                    break;
            }

        }
    }
    private static void imprimirMenuMovimientosDinero() {

        System.out.println("=== MENU MOVIMIENTOS ===");
        System.out.println("0. para salir");
        System.out.println("1. para realizar una movimiento");
        System.out.println("2. para ver todos los movimientos");
        System.out.println("3. para modificar el monto de una transaccion");
        System.out.println("4. para modificar el concepto de un movimiento");
        System.out.println("5. para volver al menu principal");

    }
    private static void addMovimiento(MovimientoDinero movimiento) {
        dataMovimientos.add(movimiento);
    }
    private static int leerOpcionMovimientosDinero() {
        System.out.println("Introduce opcion: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        while (opcion < 0 || opcion > 5) {
            System.out.println("Error...introduce opcion nuevamente:");
            opcion = Integer.parseInt(scanner.nextLine());
        }
        return opcion;
    }
    private static void cargarNuevoMovimiento() {
        MovimientoDinero movimiento = null;
        System.out.println("=== CARGAR DATOS MOVIMIENTO ===");

        System.out.println("Ingresar monto movimiento: ");
        int monto = Integer.parseInt(scanner.nextLine());
        while (monto == 0) {
            System.out.println("Error...ingresar monto del movimiento: ");
            monto = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Ingresar concepto del movimiento: ");
        String conceptoMovimiento = scanner.nextLine();
        while (conceptoMovimiento.isBlank()) {
            System.out.println("Error...ingresar el concepto del movimiento: ");
            conceptoMovimiento = scanner.nextLine();
        }

        System.out.println("Ingresar el usuario que realiza el movimiento: ");
        String usuario = scanner.nextLine();
        while (usuario.isBlank()) {
            System.out.println("Error...ingresar usuario que realiza el movimiento: ");
            usuario = scanner.nextLine();
        }
        movimiento = new MovimientoDinero(monto,conceptoMovimiento,usuario);
        addMovimiento(movimiento);
    }
    private static void imprimirMovimientos() {
        System.out.println("=== MOVIMIENTOS EXISTENTES ===");
        for (MovimientoDinero movimientos : dataMovimientos) {
            System.out.println(movimientos);
        }
    }
    private static void modificarMonto(String usuario) {
        for (MovimientoDinero m : dataMovimientos) {
            if (m.getUsuario().equalsIgnoreCase(usuario)) {
                System.out.println(m);
                System.out.println("Nuevo monto: ");
                int montoNuevo = Integer.parseInt(scanner.nextLine());
                m.setMonto(montoNuevo);
                System.out.println(m);
                break;
            }
        }
        System.out.println("Usuario no encontrado");
    }
    private static void modificarConcepto(String usuario) {
        for (MovimientoDinero m : dataMovimientos) {
            if (m.getUsuario().equalsIgnoreCase(usuario)) {
                System.out.println(m);
                System.out.println("Nuevo concepto: ");
                String conceptoNuevo = scanner.nextLine();
                m.setConceptoMovimiento(conceptoNuevo);
                System.out.println(m);
                break;
            }
        }
        System.out.println("Usuario no encontrado");
    }

    //Estos son datos precargados para los test --------------------------------------------
    public static void agregarDatosEmpresa() {


        Empresa empresa1 = new Empresa("Carrefour", "Cl 15", "7755898", "789456123");
        Empresa empresa2 = new Empresa("Ins", "Cl 89", "2345879", "123456789");
        Empresa empresa3 = new Empresa("Lidl", "Cl 44", "2224455", "234567890");
        Empresa empresa4 = new Empresa("Penny", "Cl 77", "3654785", "345678901");
        Empresa empresa5 = new Empresa("Pam", "Cl 62", "018004547958", "456789012");

        dataEmpresa.add(empresa1);
        dataEmpresa.add(empresa2);
        dataEmpresa.add(empresa3);
        dataEmpresa.add(empresa4);
        dataEmpresa.add(empresa5);

    }
    public static void agregarDatosEmpleado(){

        Empleado empleado1 = new Empleado("Carlos Vargas","123@gmail.com","Carrefour","Cajero");
        Empleado empleado2 = new Empleado("Ana Batista","234@gmail.com","Ins","Administradora");
        Empleado empleado3 = new Empleado("Cristian Agudelo","345@gmail.com","Carrefour","Gerente");
        Empleado empleado4 = new Empleado("Juliana Gutierrez","456@gmail.com","Pam","Cajera");
        Empleado empleado5 = new Empleado("Bryan Ramos","567@gmail.com","Lidl","Bodega");
        Empleado empleado6 = new Empleado("Lorena Velez","678@gmail.com","Penny","Administradora");

        dataEmpleado.add(empleado1);
        dataEmpleado.add(empleado2);
        dataEmpleado.add(empleado3);
        dataEmpleado.add(empleado4);
        dataEmpleado.add(empleado5);
        dataEmpleado.add(empleado6);
    }
    public static void agregarDatosMovimientos(){
        MovimientoDinero movimiento1 = new MovimientoDinero(15000,"Abono","Maria");
        MovimientoDinero movimiento2 = new MovimientoDinero(-15000,"Retiro","Juan");
        MovimientoDinero movimiento3 = new MovimientoDinero(27000,"Pago cliente","Diego");
        MovimientoDinero movimiento4 = new MovimientoDinero(-50500,"Trasferencia gastos","Cristian");
        MovimientoDinero movimiento5 = new MovimientoDinero(32250,"Abono nomina","Pedro");

        dataMovimientos.add(movimiento1);
        dataMovimientos.add(movimiento2);
        dataMovimientos.add(movimiento3);
        dataMovimientos.add(movimiento4);
        dataMovimientos.add(movimiento5);
    }
}