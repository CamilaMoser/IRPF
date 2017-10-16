/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Contribuinte;
import Business.DeclaracaoSimplificada;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class CalculoDeclaracaoSimplificadaTests {
    
    public DeclaracaoSimplificada declaracaoSimplificada;
    public Contribuinte contribuinte;
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     // Base inferior a 12000
    @Test
    public void calculoDeclaracaoBaseInferior12000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2);
        declaracaoSimplificada = new DeclaracaoSimplificada(contribuinte);
        double actual = declaracaoSimplificada.calculoContribuicao(contribuinte);
        double expected = 0.0;
        assertEquals(expected, actual, 0.0);
    }

    // Base igual a 12000
    @Test
    public void calculoDeclaracaoBase12000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2);
        declaracaoSimplificada = new DeclaracaoSimplificada(contribuinte);
        double actual = declaracaoSimplificada.calculoContribuicao(contribuinte);
        double expected = 0.0;
        assertEquals(expected, actual, 0.0);
    }

    // Base inferior a 24000 e superior a 12000
    @Test
    public void calculoDeclaracaoInferior24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 2001.0);
        declaracaoSimplificada = new DeclaracaoSimplificada(contribuinte);
        double actual = declaracaoSimplificada.calculoContribuicao(contribuinte);
        double expected = 1619.8574999999998;
        assertEquals(expected, actual, 0.0);
    }

    // Base igual a 24000
    @Test
    public void calculoDeclaracao24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 2000.0);
        declaracaoSimplificada = new DeclaracaoSimplificada(contribuinte);
        double actual = declaracaoSimplificada.calculoContribuicao(contribuinte);
        double expected = 1620.0;
        assertEquals(expected, actual, 0.0);        
    }

    // Base superior a 24000
    @Test
    public void calculoDeclaracaoSuperior24000() {
        contribuinte = new Contribuinte("João", "940.309.840-61", 30, 2, 26000.0, 100.0);
        declaracaoSimplificada = new DeclaracaoSimplificada(contribuinte);
        double actual = declaracaoSimplificada.calculoContribuicao(contribuinte);
        double expected = 1966.375;
        assertEquals(expected, actual, 0.0);
    }
}
