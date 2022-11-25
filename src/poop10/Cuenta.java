/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop10;

import exepcionesPropias.DepositoMaximoSobrepasado;
import exepcionesPropias.SaldoInsuficienteExeption;
import exepcionesPropias.RetiroExeption;

/**
 *
 * @author poo01alu09
 */
class Cuenta {
    private double saldo;
    private int retirosRealizados;
    
    /**
     * generamos un parametro en la clas de tipo etero el cual nos ayudara a saber cuentos retiros hemo realizado en nuestra cuenta
     */

    public Cuenta() {
    }
    public void retirar(double monto) throws SaldoInsuficienteExeption, RetiroExeption{
        System.out.println("Retirando ...... $"+monto);
        /**
         * ESTO ES MUY DE NIÑOS Y NOSOTROS YA SOMOS PADAWAN NIVEN 10
         *if(saldo < monto){
         *  System.out.println("Saldo insuficiente");}
         * else
         *  this.saldo -= monto;
        */ 
        
        if (this.retirosRealizados>=3){
            throw new RetiroExeption(); 
        }
        if(saldo < monto){
            throw new SaldoInsuficienteExeption();}
        else
            this.saldo -= monto;
            this.retirosRealizados+=1;
  
        /**
         * Generamos dos exepciones y las pusimos en una condicion ua revisara constanntemete si existe saldo uficiente para hacer el retiro
         * la otra condicion revisara que los retiro esten permitidos
         * 
         */
    }
    public void depositar(double monto ) throws DepositoMaximoSobrepasado{
        System.out.println("Depositando ...... $"+monto);
        if (monto > 20000)
            throw new DepositoMaximoSobrepasado();
        this.saldo+= monto;
    
    }

    public double getSaldo() {
        return saldo;
    }

    public int getRetirosRealizados() {
        return retirosRealizados;
    }
    

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + '}';
    }
    
    
    
    
}
