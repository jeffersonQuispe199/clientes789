package com.krakedev.clientes.servicis;

import java.util.ArrayList;
import java.util.List;

import com.krakedev.clientes.entidades.Clientes;

public class ServivioClientes {
    private ArrayList<Clientes> clientes = new ArrayList<Clientes>();

    public Clientes buscarPorCedula(String cedula) {
        for (Clientes c : clientes) {
            // Evaluamos que la cédula del objeto no sea nula para evitar NullPointerException
            if (c.getCedula() != null && c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public Clientes crear(Clientes cliente) {
        Clientes existente = buscarPorCedula(cliente.getCedula());
        if (existente != null) {
            return null;
        } else {
            clientes.add(cliente);
            return cliente;
        }
    }

    public List<Clientes> lista() {
        return clientes;
    }

    public Clientes actualizar(String cedula, Clientes clienteActualizado) {
        Clientes cliente = buscarPorCedula(cedula);
        if (cliente != null) {
            // Se actualizan todos los atributos modificables, incluyendo el nuevo campo 'email'
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido(clienteActualizado.getApellido());
            cliente.setEmail(clienteActualizado.getEmail());
        }
        return cliente;
    }

    public boolean eliminar(String cedula) {
        Clientes cliente = buscarPorCedula(cedula);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        } else {
            return false;
        }
    }
}