package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

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

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year() != null && meuTituloOmdb.year().length() > 4){

            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano por conta de caracter não esperado"){

            };
        }

        this.anoDelançamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    public void exibeFichaTecnica(){
        System.out.println(nome);
        System.out.println(anoDelançamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totaldeAvaliacoes ++;
    }

    @Override
    public String toString(){
        return "(nome: " + this.getNome() + ", ano de lançamento: " + this.getAnoDelançamento() + ", duração em minutos: " + this.getDuracaoEmMinutos() + ")";
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
