package Cajero;

import javax.swing.JOptionPane;//importacion necesaria para el uso de los cuadros de dialogo

public class Operaciones {
    
    //variables globales para que puedan ser modificados de ser necesario
    int saldo=90000; //saldo inicial
    String clave="1234";//clave predeterminada
    
    public void menu(){//metodo que contiene el menu de la aplicacion
        
        String ax;
        int op=0;        
        do{
            ax = JOptionPane.showInputDialog(null, "1. Saldo n 2. Consignar n 3. Retirar n 4. Cambiar Clave n 5. Salir");
            if(ax!=null && Validar.isNum(ax)){//validacion para el menu
                op = Integer.parseInt(ax);
                switch(op){
                    case 1:
                        verSal(); break; 
                    case 2:
                        consig(); break;
                    case 3:
                        retirar(); break;
                    case 4: 
                        chanPass(); break;
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Digite una opcion valida....");
            }                    
        }while(op !=5);//cuando se digita 5 se finaliza la aplicacion        
    }
    
    public void verSal(){//metodo para ver el saldo de la cuenta
        JOptionPane.showMessageDialog(null, "Tu saldo a la fecha es: "+saldo);
    }
    
    public void consig(){//metodo para realizar la consignacion
        String ax; int consig=0;        
        
        ax = JOptionPane.showInputDialog(null, "Cuanto desea consginar? ");
        if((ax!=null) && !ax.equals("") && Validar.isNum(ax)){//triple validacion, si se ingreso algo, y si es numero lo ingresado            
            consig = Integer.parseInt(ax);
            if(consig>0){//si el valor a consignar es mayor que 0 se realiza la consignacion
                saldo+=consig;//se suma el nuevo valor al saldo
            }else{
                JOptionPane.showMessageDialog(null, "Consigne una cantidad mayor a 0 !!!");
            }                    
        }else{
             JOptionPane.showMessageDialog(null, "Ingrese un valor a consignar!!!");
        }
    }
    
    public void retirar(){//metodo para retirar del saldo
        
        String ax;                
        ax = JOptionPane.showInputDialog(null, "Digite su clave.... ");
        
        if(ax==null){//validacion por si se selecciona cancelar del cuadro de dialogo y evitar errores 
            
        }else{
            if(!ax.equals("")){            
                if(ax.equals(clave)){//si la clave digitada coincide con la clave
                    ax = JOptionPane.showInputDialog(null, "a. 5000 n b. 10.000 n c. 20.000 n d. 50.000n e. 100.000n f. Ingresar valor",
                            "CANTIDAD A RETIRAR", JOptionPane.INFORMATION_MESSAGE);
                    if(ax!=null){
                        if(!ax.equals("")){
                            switch(ax){
                                case "a":
                                    if((saldo-5000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=5000;
                                    }                            
                                    break;
                                case "b":
                                   if((saldo-10000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=10000;
                                    }
                                    break;
                                case "c":
                                   if((saldo-20000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=20000;
                                    }
                                    break;
                                case "d":
                                    if((saldo-50000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=50000;
                                    }
                                    break;
                                case "e":
                                    if((saldo-100000>=10000)){//se verifica si al retirar queda con un saldo minimo de 10.000
                                        saldo-=100000;
                                    }
                                    break;
                                case "f":
                                    ax = JOptionPane.showInputDialog(null, "Digite el valor a retirar: ");
                                    if(!ax.equals("") && Validar.isNum(ax) && (Integer.parseInt(ax)>0) && (saldo-Integer.parseInt(ax)>=10000) ){
                                        saldo-= Integer.parseInt(ax);
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
                    JOptionPane.showMessageDialog(null, "La clave ingresada no coincide....");
                }
            }
        }              
    }
   
    public void chanPass(){//metodo para cambiar la contraseña
        
        String ax, cl;
        
        ax = JOptionPane.showInputDialog(null, "Digite su clave....");
        if(ax!=null){
            if(!ax.equals("")){            
                if(ax.equals(clave)){//si la clave digitada coincide con la clave que existe
                   cl = JOptionPane.showInputDialog(null, "Digite su nueva clave");
                   if(cl!=null){
                       if(cl.length()>3){//si el tamaño de la nueva contraseña tiene mas de 3 caracteres se puede cambiar
                            ax=null;//se elimina el valor contenido con anterioridad de la variable
                            ax="Su anterior clave es:"+clave;
                            clave=cl;
                            ax+="nSu nueva clave es: "+clave; 
                            JOptionPane.showMessageDialog(null, ax);
                       }
                       else{
                            JOptionPane.showMessageDialog(null, "La clave que desea cambiar es muy corta...");
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