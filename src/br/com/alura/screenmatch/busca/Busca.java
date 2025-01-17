package br.com.alura.screenmatch.busca;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Busca {
    private List<Titulo> titulos;
    private Gson gson;

    public Busca(){
        titulos = new ArrayList<Titulo>();
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public Titulo buscarFilmes(String endereco){

        Titulo tituloEncontrado = null;

        try {
            //Definição de comunicação HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            //Envio de requisição com nome do filme desejado
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Atribuição de resposta a String
            String json = response.body();
            System.out.println(json);

            //Projetor TituloOmdb recebe o Json e configura ele como um titulo
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            tituloEncontrado = new Titulo(meuTituloOmdb);

            //Adiciona titulo à lista de Titulos
            this.titulos.add(tituloEncontrado);

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de endereço, verifique o texto e tente novamente");
            System.out.println(e.getMessage());

        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return tituloEncontrado;
    }

    public String EscreveJsonBuscas() {

        String json;

        try {
            FileWriter escrita = new FileWriter("filmes.json");
            json = gson.toJson(this.titulos);
            escrita.write(json);
            escrita.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public void limparListaDeTitulos(){
        this.titulos.clear();
    }
}
