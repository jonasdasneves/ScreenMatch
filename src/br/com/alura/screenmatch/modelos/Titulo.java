package br.com.alura.screenmatch.modelos;

public class Titulo {

    private String nome;
    private int anoDelançamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totaldeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDelançamento) {
        this.nome = nome;
        this.anoDelançamento = anoDelançamento;
    }

    public void exibeFichaTecnica(){
        System.out.println(nome);
        System.out.println(anoDelançamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totaldeAvaliacoes ++;
    }

    public double pegaMedia(){
        return (somaDasAvaliacoes/totaldeAvaliacoes);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDelançamento() {
        return anoDelançamento;
    }

    public void setAnoDelançamento(int anoDelançamento) {
        this.anoDelançamento = anoDelançamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public int getTotaldeAvaliacoes() {
        return totaldeAvaliacoes;
    }

    public void setTotaldeAvaliacoes(int totaldeAvaliacoes) {
        this.totaldeAvaliacoes = totaldeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

}
