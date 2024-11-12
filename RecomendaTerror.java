import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Filme {
    private String titulo;
    private String subgenero;
    private int nivelMedo;

    public Filme(String titulo, String subgenero, int nivelMedo) {
        this.titulo = titulo;
        this.subgenero = subgenero;
        this.nivelMedo = nivelMedo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubgenero() {
        return subgenero;
    }

    public int getNivelMedo() {
        return nivelMedo;
    }

    @Override
    public String toString() {
        return "Filme: " + titulo + " | Subgênero: " + subgenero + " | Nível de Medo: " + nivelMedo;
    }
}

class RecomendadorFilmes {
    private List<Filme> filmes;

    public RecomendadorFilmes() {
        filmes = new ArrayList<>();
        adicionarFilmes();
    }

    private void adicionarFilmes() {
        filmes.add(new Filme("Hereditário", "Terror Psicológico", 9));
        filmes.add(new Filme("Invocação do Mal", "Sobrenatural", 8));
        filmes.add(new Filme("Halloween", "Slasher", 7));
        filmes.add(new Filme("O Exorcista", "Sobrenatural", 10));
        filmes.add(new Filme("Corra!", "Terror Psicológico", 6));
        filmes.add(new Filme("Pânico", "Slasher", 5));
        filmes.add(new Filme("A Bruxa", "Terror Psicológico", 7));
    }

    public List<Filme> recomendarFilmes(String subgenero, int nivelMedoMinimo) {
        List<Filme> recomendados = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.getSubgenero().equalsIgnoreCase(subgenero) && filme.getNivelMedo() >= nivelMedoMinimo) {
                recomendados.add(filme);
            }
        }
        return recomendados;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecomendadorFilmes recomendador = new RecomendadorFilmes();

        System.out.println("Bem-vindo ao Recomendador de Filmes de Terror!");
        System.out.print("Escolha um subgênero (Terror Psicológico, Sobrenatural, Slasher): ");
        String subgenero = scanner.nextLine();

        System.out.print("Qual o nível mínimo de medo desejado (1-10)? ");
        int nivelMedoMinimo = scanner.nextInt();

        List<Filme> recomendados = recomendador.recomendarFilmes(subgenero, nivelMedoMinimo);

        if (recomendados.isEmpty()) {
            System.out.println("Não encontramos filmes para o critério escolhido.");
        } else {
            System.out.println("Recomendações de Filmes:");
            for (Filme filme : recomendados) {
                System.out.println(filme);
            }
        }

        scanner.close();
    }
}
