package Cajero;
//https://es.stackoverflow.com/questions/71346/c%C3%B3mo-convertir-un-string-en-int-en-java
public class Validar {
    
    public static boolean isNum(String a){//metodo para validar si es un numero        
        
        try{
            int b = Integer.parseInt(a);
            return true;//si se puede convertir a numero devuelve verdadero
        }
        catch(NumberFormatException e){
            return false;//si no se puede convertir a numero devuelve falso
        }        
    }
    
}