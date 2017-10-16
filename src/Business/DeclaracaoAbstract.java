/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Lucas
 */
abstract class DeclaracaoAbstract {    
    private double impostoPago = 0.0;
    public static final double FAIXA_12 = 12000.0;
    public static final double FAIXA_24 = 24000.0;
    private Contribuinte contribuinte;       

    public DeclaracaoAbstract(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }
    
    public void setImpostoPago(double impostoPago){
        this.impostoPago = impostoPago;
    }
    
    public double getImpostoPago(){
        return impostoPago;
    }
    
    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }
    
    public Contribuinte getContribuinte(){
        return contribuinte;
    }    
    
    public double calculoBase(Contribuinte contribuinte){
        return contribuinte.getTotalRend() - contribuinte.getContriOficial();
    }
    
    public abstract double calculoContribuicao(Contribuinte contribuinte);
}
