/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados.relatorios;

/**
 *
 * @author renat
 */
public class DadosRelatorioEstado {
    private String estado;
    private int quantidade;
    private double valor;

    public DadosRelatorioEstado(String estado, int quantidade, double valor) {
        this.estado = estado;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    
    
    public String getEstado() {
        return estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }
    
    
}
