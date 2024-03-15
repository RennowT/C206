package Models;

public class Livro {
    private String titulo;
    private int paginas;

    public Livro(String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
