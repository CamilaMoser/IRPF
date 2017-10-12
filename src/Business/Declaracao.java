package Business;

import java.text.NumberFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camila
 */
public class Declaracao {
    private char tipoDeclaracao;
    private double impostoPago;
    private static double faixa12 = 12000;
    private static double faixa24 = 24000;
    private Contribuinte contribuinte;
    
    public Declaracao (Contribuinte contribuinte, char tipoDeclaracao){
        this.contribuinte = contribuinte;
        this.tipoDeclaracao = tipoDeclaracao;
    }
    
    public char getTipoDeclaracao(){
        return tipoDeclaracao;
    }
    
    public double getImpostoPago(){
        return impostoPago;
    }
    
    public void setImpostoPago(double impostoPago){
        this.impostoPago = impostoPago;
    }
    
    public Contribuinte getContribuinte(){
        return contribuinte;
    }
    
    public String tratarTipoDeDeclaracao (char tipo){
        String tipoDeclar = "";
        if(tipo == 's' || tipo == 'S'){
            tipoDeclar = "Simplificada";
        }else if(tipo == 'c' || tipo == 'C'){
            tipoDeclar = "Completa";
        }
        return tipoDeclar;
    }
    
    public double calculoBase(Contribuinte contribuinte){
        return contribuinte.getTotalRend() - contribuinte.getContriOficial();
    }
    
    public double calculoContriCompleta(Contribuinte contribuinte){
        double base = calculoBase(contribuinte);
        double valorDesconto;
                
        if(contribuinte.getIdade() < 65){
            if(contribuinte.getNumDepen() <= 2){
                valorDesconto = (base * 0.02);
                base -= valorDesconto;
            } else if (contribuinte.getNumDepen() > 2 && contribuinte.getNumDepen() <= 5){
                valorDesconto = (base * 0.035);
                base -= valorDesconto;
            }else {
                valorDesconto = (base * 0.05);
                base -= valorDesconto;
            }
        } else {
            if(contribuinte.getNumDepen() <= 2){
                valorDesconto = (base * 0.03);
                base -= valorDesconto;
            } else if (contribuinte.getNumDepen() > 2 && contribuinte.getNumDepen() <= 5){
                valorDesconto = (base * 0.045);
                base -= valorDesconto;
            }else {
                valorDesconto = (base * 0.06);
                base -= valorDesconto;
            }
        }
        if (base <= faixa12){
            return 0.0;
        }else if (base > faixa12 && base < faixa24){
            return ((base - faixa12) * 0.15);
        }else{
            impostoPago = (((faixa12) * 0.15) + ((base - faixa24) * 0.275));
            return impostoPago;
        }
    }
    
    public double calculoContriSimples(Contribuinte contribuinte){
        double base = calculoBase(contribuinte);
        double valorDesconto = (base * 0.05);
        base -= valorDesconto;
        
        if(base <= faixa12){
            return 0.0;
        }else if(base > faixa12 && base < faixa24){
            return ((base - faixa12) * 0.15);
        }else{
            impostoPago = ((faixa12 * 0.15) + ((base - faixa24) * 0.275));
            return impostoPago;
        }
    }

    public String toString(Contribuinte contribuinte){
        String dadosImprimir = "";
        dadosImprimir = "Declaração de Imposto de Renda de Pessoa Física: " + "\n" + "\n" + "Tipo de Declaração: "
            + tratarTipoDeDeclaracao(getTipoDeclaracao()) + "\n" + "Dados Pessoa Física" + "\n" + "Nome: " + contribuinte.getNome()
            + "\n" + "CPF: " + contribuinte.getCpf() + "\n" + "Idade: " + contribuinte.getIdade() + "\n" 
            + "Número de Dependentes: " + contribuinte.getNumDepen() + "\n" + "Total de Rendimentos: "
            + NumberFormat.getCurrencyInstance().format(contribuinte.getTotalRend()) + "\n"
            + "Contribuição Previdenciária Oficial: " + NumberFormat.getCurrencyInstance().format(contribuinte.getContriOficial()) + "\n" 
            + "IRPF: " + NumberFormat.getCurrencyInstance().format(getImpostoPago()) + "\n";
        return dadosImprimir;
    }
    
}
