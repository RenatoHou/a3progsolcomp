
package model;


public class Cliente {
    private int cpf;
    private String nome;
    private int idade;

    public Cliente(int cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
    
}
