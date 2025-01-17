package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.busca.Busca;
import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        String busca = new String("");


        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        Busca pesquisa = new Busca();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite o filme desejado");
            busca = input.nextLine();
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + apiKey;

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            pesquisa.buscarFilmes(endereco);
        }
        pesquisa.EscreveJsonBuscas();
        pesquisa.limparListaDeTitulos();

    }
}
