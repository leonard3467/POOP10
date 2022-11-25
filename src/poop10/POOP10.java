/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop10;

import exepcionesPropias.DepositoMaximoSobrepasado;
import exepcionesPropias.RetiroExeption;
import exepcionesPropias.SaldoInsuficienteExeption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poo01alu09
 */
public class POOP10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //excepciones 
        //__________Exepsiones No marcadas____________
        System.out.println("######## aqui forcamos a que un arreglo no jalara");
        try{
            String mensajes[]={"Mensaje 1", "Mensaje2", "Mensaje 3"};
            for (int i = 0; i < 4 ; i++) {
                System.out.println(mensajes[i]);
            // que pasa si 
        }
        }catch(ArrayIndexOutOfBoundsException e ){
            System.out.println("Error apuntador fuera de los limites");
            //e.printStackTrace();
        }
        try{
            float x=10/5;  // con una division entre 0
            System.out.println("X ="+x);
        }catch(ArithmeticException e){
            System.out.println("no existe la divicion entre 0");
        }finally{
            System.out.println("cualquier cosa que suceda entra al finally ");
        }
        // el fainally nos sirve para ejecutar una instruccion pase lo que pase
        // abra que descubrir cuando usarlo 
        
        System.out.println("###################");
        try{
            float x=10/0;  // con una division entre 0
            System.out.println("X ="+x);
        }catch(ArithmeticException e){
            System.out.println("no existe la divicion entre 0");
        }
        // cada try tiene su propias variables
        System.out.println("######## catch anidados #####");
        try{
            float x=10/0;  // con una division entre 0
            System.out.println("X ="+x);
        }
        catch(ArrayIndexOutOfBoundsException e ){
            System.out.println("Error apuntador fuera de los limites");
            //e.printStackTrace();
        }
        catch(ArithmeticException e){
            System.out.println("no existe la divicion entre 0");
        }
        System.out.println("######## propagacion de exepciones ########");
           try{
        float division=metodoDivision(4,0);
        System.out.println("Divison "+division);
         }catch(ArithmeticException e){
               System.out.println("no existe divison entre 0");
         }
           //______________ exepciones marcadas  ___________
        try{
            float div=metodoDivisionMarcada(3,0);
        }catch(ArithmeticException e){
            System.out.println("exepcion de division entre 0 MARCADA");}
        System.out.println("############### creacion de exepciones ###############");
        
        
        Cuenta cuenta=new Cuenta();
        try {
            cuenta.depositar(18_000);
        } catch (DepositoMaximoSobrepasado ex) {
           System.out.println(ex.getMessage());
        }
        System.out.println("Saldo de cuenta : $" + cuenta.getSaldo());
        try {
            try {
                cuenta.retirar(10_000);
            } catch (RetiroExeption ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SaldoInsuficienteExeption ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Saldo de cuenta : $" + cuenta.getSaldo());
        try {
            try {
                cuenta.retirar(10_000);
            } catch (RetiroExeption ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SaldoInsuficienteExeption ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Saldo de cuenta : $" + cuenta.getSaldo());
        
        try {
            // no se pueden depositar mas de 20_000
            // solamente se pueden hacer maximo 3 retiros
            cuenta.depositar(20_001);
        } catch (DepositoMaximoSobrepasado ex) {
            System.out.println(ex.getMessage());
        }
        try {
            cuenta.depositar(15_000);
        } catch (DepositoMaximoSobrepasado ex) {
            System.out.println(ex.getMessage());
        }
         System.out.println("Saldo de cuenta : $" + cuenta.getSaldo());
         
        try {
            cuenta.retirar(5000);
            cuenta.retirar(3000);
            cuenta.retirar(2000);
        } catch (SaldoInsuficienteExeption ex) {
            System.out.println(ex.getMessage());
        } catch (RetiroExeption ex) {
           System.out.println(ex.getMessage());
        }
        
        System.out.println("Saldo de cuenta : $" + cuenta.getSaldo());
        /**
        * nuestro programa revisa cada que depositamos o retiramos para ver si alguna de las exepciones ocurre 
        * y dado a que siempre estamos depositando o retirando  existen muchos try catch 
        * 
         */
        
    }

    private static float metodoDivision(int a, int b) {
        // es dificil hacer una exepcion en u metodo
        /*
        try{
       return a/b;
        }catch(ArithmeticException e){
            System.out.println("no existe division entre 0");
        }  NO NOS SIRVE ;-;*/
        return a/b;
        
        
    }

    private static float metodoDivisionMarcada(int i, int i0) {
      return i/i0;
    }


    
}
