/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class CalculoDeclaracaoCompletaTests {

    public DeclaracaoCompleta declaracaoCompleta;
    public Contribuinte contribuinte;

    // Base inferior a 12000
    @Test
    public void calculoDeclaracaoBaseInferior12000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 14000.0, 2001.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 0.0;
        assertEquals(expected, actual, 0.0);
    }

    // Base igual a 12000
    @Test
    public void calculoDeclaracaoBase12000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 14000.0, 2000.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 0.0;
        assertEquals(expected, actual, 0.0);
    }

    // Base inferior a 24000 e superior a 12000
    @Test
    public void calculoDeclaracaoInferior24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 2001.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 1727.853;
        assertEquals(expected, actual, 0.0);
    }

    // Base igual a 24000
    @Test
    public void calculoDeclaracao24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 2000.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 1728.0;
        assertEquals(expected, actual, 0.0);
    }

    // Base superior a 24000
    @Test
    public void calculoDeclaracaoSuperior24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2180.05;
        assertEquals(expected, actual, 0.0);
    }

    // um dependente idade maior que 65
    @Test
    public void calculoDeclaracaoUmDependenteIdataMaior65() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 65, 1, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2108.825;
        assertEquals(expected, actual, 0.0);
    }

    // dois dependente idade maior que 65
    @Test
    public void calculoDeclaracaoDoisDependenteIdataMaior65() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 65, 2, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2108.825;
        assertEquals(expected, actual, 0.0);
    }

    // tres dependente idade maior que 65
    @Test
    public void calculoDeclaracaoTresDependenteIdataMaior65() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 65, 3, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2001.9875;
        assertEquals(expected, actual, 0.0);
    }

    // cinco dependente idade maior que 65
    @Test
    public void calculoDeclaracaoCincoDependenteIdataMaior65() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 65, 5, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2001.9875;
        assertEquals(expected, actual, 0.0);
    }

    // seis dependente idade maior que 65
    @Test
    public void calculoDeclaracaoSeisDependenteIdataMaior65() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 65, 6, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 1895.15;
        assertEquals(expected, actual, 0.0);
    }

    // tres dependente idade menor que 65
    @Test
    public void calculoDeclaracaoTresDependenteIdataMaior64() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 64, 3, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2073.2125;
        assertEquals(expected, actual, 0.0);
    }

    // cinco dependente idade maior que 64
    @Test
    public void calculoDeclaracaoCincoDependenteIdataMaior64() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 64, 5, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 2073.2125;
        assertEquals(expected, actual, 0.0);
    }

    // seis dependente idade maior que 65
    @Test
    public void calculoDeclaracaoSeisDependenteIdataMaior64() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 64, 6, 26000.0, 100.0);
        declaracaoCompleta = new DeclaracaoCompleta(contribuinte);
        double actual = declaracaoCompleta.calculoContribuicao();
        double expected = 1966.375;
        assertEquals(expected, actual, 0.0);
    }

}
