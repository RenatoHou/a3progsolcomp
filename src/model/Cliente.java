package model;


public class Cliente {
    private String cpf;
    private String nome;
    private int idade;
    private String email;
    private String senha;

    public Cliente(String cpf, String nome, int idade, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }

    
    
    public Cliente(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
