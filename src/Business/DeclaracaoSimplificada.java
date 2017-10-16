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
public class DeclaracaoSimplificada extends DeclaracaoAbstract {

    public DeclaracaoSimplificada(Contribuinte contribuinte) {
        super(contribuinte);
    }

    @Override
    public double calculoContribuicao() {
        double base = super.calculoBase(super.getContribuinte());
        double valorDesconto = (base * 0.05);
        base -= valorDesconto;

        if (base <= DeclaracaoAbstract.FAIXA_12) {
            return super.getImpostoPago();
        } else if (base > DeclaracaoAbstract.FAIXA_12 && base < DeclaracaoAbstract.FAIXA_24) {
            super.setImpostoPago(((base - DeclaracaoAbstract.FAIXA_12) * 0.15));
            return super.getImpostoPago();
        } else {
            super.setImpostoPago(((DeclaracaoAbstract.FAIXA_12 * 0.15) + ((base - DeclaracaoAbstract.FAIXA_24) * 0.275)));
            return super.getImpostoPago();
        }
    }
}
