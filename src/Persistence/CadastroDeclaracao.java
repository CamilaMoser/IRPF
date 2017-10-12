/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Declaracao;
import java.util.ArrayList;

/**
 *
 * @author Camila
 */
public class CadastroDeclaracao {
    private ArrayList<Declaracao> declar;
    
    public CadastroDeclaracao(){
        declar = new ArrayList<>();
    }
    
    public ArrayList<Declaracao> getDeclar(){
        return declar;
    }
    
    public void incluirDeclaracao(Declaracao declaracao){
        
    }
}
