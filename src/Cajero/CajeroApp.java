package Cajero;

public class CajeroApp {
    
    public static void main(String[] args) {
        
        Operaciones trin = new Operaciones(); //creacion del objeto para la manipulacion de los metodos de la clase cajero2        
        trin.menu();//invocacion del menu por medio del objeto trin
        System.exit(0); //cuando se sale del menu se finaliza la aplicacion
    }    
}