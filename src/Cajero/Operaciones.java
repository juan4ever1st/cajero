package Cajero;

import javax.swing.JOptionPane;//importacion necesaria para el uso de los cuadros de dialogo

public class Operaciones {
    
    //variables globales para que puedan ser modificadas de ser necesario
    int saldo=100000; //saldo inicial
    String clave="1234";//clave predeterminada
    
    public void menu(){//metodo que contiene el menu de la aplicacion
        
        String aux;
        int op=0;        
        do{
            aux = JOptionPane.showInputDialog(null, "MENU PRINCIPAL \n\n 1. SALDO \n 2. DEPOSITAR \n 3. RETIRAR \n 4. CAMBIAR CLAVE \n 5. SALIR \n");
            if(aux!=null && Validar.isNum(aux)){//validacion para el menu
                op = Integer.parseInt(aux);
                switch(op){
                    case 1:
                        verSal();
                        break; 
                    case 2:
                        depo();
                        break;
                    case 3:
                        retirar();
                        break;
                    case 4: 
                        cambiarPass();
                        break;
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Digite una opcion valida.");
            }                    
        }while(op !=5);//cuando se digita 5 se finaliza la aplicacion        
    }
    
    public void verSal(){//metodo para ver el saldo de la cuenta
        JOptionPane.showMessageDialog(null, "DISPONIBLE: AR$ "+ saldo);
    }
    
    public void depo(){//metodo para realizar un deposito
        String aux; int deposito=0;        
        
        aux = JOptionPane.showInputDialog(null, "Cuanto desea depositar? ");
        if((aux!=null) && !aux.equals("") && Validar.isNum(aux)){//triple validacion, si se ingreso algo, y si es numero lo ingresado            
            deposito = Integer.parseInt(aux);
            if(deposito > 0){//si el valor a consignar es mayor que 0 se realiza la consignacion
                saldo+=deposito;//se suma el nuevo valor al saldo
            }else{
                JOptionPane.showMessageDialog(null, "No es posible depositar ese importe!!!");
            }                    
        }else{
             JOptionPane.showMessageDialog(null, "Ingrese un monto a depositar:");
        }
    }
    
    public void retirar(){//metodo para retirar del saldo
        
        String aux;                
        aux = JOptionPane.showInputDialog(null, "Digite su clave: ");
        
        if(aux==null){//validacion por si se selecciona cancelar del cuadro de dialogo y evitar errores 
            
        }else{
            if(!aux.equals("")){            
                if(aux.equals(clave)){//si la clave digitada coincide con la clave
                    aux = JOptionPane.showInputDialog(null, "A. 500 \n B. 1.000 \n C. 2.000 \n D. 5.000 \n E. 10.000 \n F. INGRESAR MONTO",
                            "CANTIDAD A RETIRAR", JOptionPane.INFORMATION_MESSAGE);
                    if(aux!=null){
                        if(!aux.equals("")){
                            switch(aux){
                                case "A":
                                    if((saldo-500>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=500;
                                    }                            
                                    break;
                                case "B":
                                   if((saldo-1000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=1000;
                                    }
                                    break;
                                case "C":
                                   if((saldo-2000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=2000;
                                    }
                                    break;
                                case "D":
                                    if((saldo-5000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=5000;
                                    }
                                    break;
                                case "E":
                                    if((saldo-10000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=10000;
                                    }
                                    break;
                                case "F":
                                    aux = JOptionPane.showInputDialog(null, "Ingrese el monto a retirar: ");
                                    if(!aux.equals("") && Validar.isNum(aux) && (Integer.parseInt(aux)>0) && (saldo-Integer.parseInt(aux)>=10000) ){
                                        saldo-= Integer.parseInt(aux);
                                    }
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Digite una opcion valida", "OPCION INCORRECTA", JOptionPane.ERROR_MESSAGE);
                                    break;
                            }             
                        } 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "La clave ingresada es incorrecta.");
                }
            }
        }              
    }
   
    public void cambiarPass(){//metodo para cambiar la contraseña
        
        String aux, cl;
        
        aux = JOptionPane.showInputDialog(null, "Digite su clave actual....");
        if(aux!=null){
            if(!aux.equals("")){            
                if(aux.equals(clave)){//si la clave digitada coincide con la clave que existe
                   cl = JOptionPane.showInputDialog(null, "Digite su nueva clave");
                   if(cl!=null){
                       if(cl.length()>3){//si el tamaño de la nueva contraseña tiene mas de 3 caracteres se puede cambiar
                            aux = null;//se elimina el valor contenido con anterioridad de la variable
                            aux = "Su anterior clave es: "+clave;
                            clave = cl;
                            aux+= "\nSu nueva clave es: "+clave; 
                            JOptionPane.showMessageDialog(null, aux);
                       }
                       else{
                            JOptionPane.showMessageDialog(null, "La clave ingresada es muy corta...(Debe contener al menos 4 carateres)");
                       }
                   }                   
                }
                else{
                    JOptionPane.showMessageDialog(null, "La clave ingresada no coincide....");
                }
            }
        }        
    }
}