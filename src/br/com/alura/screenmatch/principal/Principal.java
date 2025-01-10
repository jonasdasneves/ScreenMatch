package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1988);
        meuFilme.setDuracaoEmMinutos(120);
        System.out.println(meuFilme.getDuracaoEmMinutos());

        Filme filmeDoPaulo = new Filme("Dogville", 1988);
        filmeDoPaulo.setDuracaoEmMinutos(150);

        Filme outroFilme = new Filme("Jujutsu Kaisen 0", 2022);
        outroFilme.setDuracaoEmMinutos(100);

        ArrayList<Filme> filmes = new ArrayList<Filme>();

        filmes.add(meuFilme);
        filmes.add(filmeDoPaulo);
        filmes.add(outroFilme);

        System.out.println(filmes);
        System.out.println(filmes.get(2).toString());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        meuFilme.avalia(8);
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost",2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(12);
        lost.setMinutosPorEpisodio(45);
        System.out.println("Minutos para maratonar lost: "+lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}
