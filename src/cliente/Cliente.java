package cliente;

import java.util.UUID;

public class Cliente {
    private final UUID id;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
