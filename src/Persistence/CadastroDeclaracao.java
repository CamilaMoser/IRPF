/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.*;
import java.util.ArrayList;

/**
 *
 * @author Camila
 */
public class CadastroDeclaracao {
    private ArrayList<DeclaracaoInterface> declaracoes;
    
    public CadastroDeclaracao(){
        declaracoes = new ArrayList<>();
    }
    
    public ArrayList<DeclaracaoInterface> getDeclaracoes(){
        return declaracoes;
    }
    
    public void incluirDeclaracao(DeclaracaoInterface declaracao){        
        declaracao.calculoContribuicao();
        declaracoes.add(declaracao);
    }

    @Override
    public String toString() {
        String str = "";
        for (DeclaracaoInterface declaracao : declaracoes) {
            str += declaracao.toString() + "\n";
        }
        return str;
    }
    
    
}
