package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){

        if (classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos do momento");
        }
        else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Está muito bem avaliado");
        }
        else{
            System.out.println("Coloque na sua lista para assistir mais tarde!");
        }

    }
}
