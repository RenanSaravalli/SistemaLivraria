package livro;

import autor.Autor;

import java.time.LocalDate;
import java.util.UUID;

public class Livro {
    private final UUID codigo;
    private String titulo;
    private Autor autor;
    private String genero;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(String titulo, Autor autor, String genero, LocalDate dataCadastro) {
        this.codigo = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = true;
        this.dataCadastro = dataCadastro;

    }

    public Livro(String titulo, Autor autor, String genero, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this.codigo = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = true;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", genero='" + genero + '\'' +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
