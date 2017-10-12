package Business;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camila
 */
public class Contribuinte {
    private String nome;
    private String cpf;
    private int idade;
    private int numDepen;
    private double totalRend;
    private double contriOficial;
    
    public Contribuinte (String nome, String cpf, int idade, int numDepen,
            double totalRend, double contriOficial){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.numDepen = numDepen;
        this.totalRend = totalRend;
        this.contriOficial = contriOficial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumDepen() {
        return numDepen;
    }

    public void setNumDepen(int numDepen) {
        this.numDepen = numDepen;
    }

    public double getTotalRend() {
        return totalRend;
    }

    public void setTotalRend(double totalRend) {
        this.totalRend = totalRend;
    }

    public double getContriOficial() {
        return contriOficial;
    }

    public void setContriOficial(double contriOficial) {
        this.contriOficial = contriOficial;
    }

    @Override
    public String toString() {
        return "Contribuinte{" + "Nome:" + nome + ", CPF:" + cpf + ", Idade:" + idade 
                + ", Número de Dependentes:" + numDepen + ", Total de Rendimentos:" 
                + totalRend + ", Contribuição Previdenciária Oficial:" + contriOficial + '}';
    }
    
    
}
