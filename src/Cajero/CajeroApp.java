package Cajero;

public class CajeroApp {
    
    public static void main(String[] args) {
        
        Operaciones opera = new Operaciones(); //creacion del objeto para la manipulacion de los metodos de la clase operaciones        
        opera.menu();//llamamos al menu por medio del objeto opera
        System.exit(0); //cuando se sale del menu se finaliza la aplicacion
    }    
}