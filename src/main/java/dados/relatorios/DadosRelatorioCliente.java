/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados.relatorios;

import model.Cliente;

/**
 *
 * @author renat
 */
public class DadosRelatorioCliente {
    private double valortotal;
    private Cliente cliente;

    public DadosRelatorioCliente(double valortotal, Cliente cliente) {
        this.valortotal = valortotal;
        this.cliente = cliente;
    }

    
    
    public double getValortotal() {
        return valortotal;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    
}
