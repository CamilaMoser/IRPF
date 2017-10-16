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
public interface DeclaracaoInterface {    
    
    public void setImpostoPago(double impostoPago);        
    
    public double getImpostoPago();            
    
    public void setContribuinte(Contribuinte contribuinte);    
    
    public Contribuinte getContribuinte();
    
    public double calculoBase(Contribuinte contribuinte);
    
    public abstract double calculoContribuicao(Contribuinte contribuinte);    
}
