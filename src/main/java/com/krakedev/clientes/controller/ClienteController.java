package com.krakedev.clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Clientes;
import com.krakedev.clientes.servicis.ServivioClientes;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ServivioClientes servicioCliente = new ServivioClientes();

    @PostMapping
    public Clientes crear(@RequestBody Clientes cliente) {
        return servicioCliente.crear(cliente);
    }

    @GetMapping
    public List<Clientes> lista() {
        return servicioCliente.lista();
    }

    @GetMapping("/{cedula}")
    public Clientes buscar(@PathVariable String cedula) {
        return servicioCliente.buscarPorCedula(cedula);
    }

    @PutMapping("/{cedula}")
    public Clientes actualizar(@PathVariable String cedula, @RequestBody Clientes clienteActualizado) {
        return servicioCliente.actualizar(cedula, clienteActualizado);
    }

    @DeleteMapping("/{cedula}")
    public boolean eliminar(@PathVariable String cedula) {
        return servicioCliente.eliminar(cedula);
    }
}