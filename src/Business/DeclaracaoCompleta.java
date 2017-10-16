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
public class DeclaracaoCompleta extends DeclaracaoAbstract{

    public DeclaracaoCompleta(Contribuinte contribuinte) {
        super(contribuinte);
    }    
    
    @Override
    public double calculoContribuicao(Contribuinte contribuinte) {
        double base = super.calculoBase(contribuinte);
        double valorDesconto;
                
        if(super.getContribuinte().getIdade() < 65){
            if(super.getContribuinte().getNumDepen() <= 2){
                valorDesconto = (base * 0.02);
                base -= valorDesconto;
            } else if (super.getContribuinte().getNumDepen() > 2 && super.getContribuinte().getNumDepen() <= 5){
                valorDesconto = (base * 0.035);
                base -= valorDesconto;
            }else {
                valorDesconto = (base * 0.05);
                base -= valorDesconto;
            }
        } else {
            if(super.getContribuinte().getNumDepen() <= 2){
                valorDesconto = (base * 0.03);
                base -= valorDesconto;
            } else if (super.getContribuinte().getNumDepen() > 2 && super.getContribuinte().getNumDepen() <= 5){
                valorDesconto = (base * 0.045);
                base -= valorDesconto;
            }else {
                valorDesconto = (base * 0.06);
                base -= valorDesconto;
            }
        }
        if (base <= DeclaracaoAbstract.FAIXA_12){
            return super.getImpostoPago();
        }else if (base > DeclaracaoAbstract.FAIXA_12 && base < DeclaracaoAbstract.FAIXA_24){
            return ((base - DeclaracaoAbstract.FAIXA_12) * 0.15);
        }else{
            super.setImpostoPago((((DeclaracaoAbstract.FAIXA_12) * 0.15) + ((base - DeclaracaoAbstract.FAIXA_24) * 0.275)));
            return super.getImpostoPago();
        }
    }    
}
