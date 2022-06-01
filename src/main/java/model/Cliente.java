
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
    
    
}
