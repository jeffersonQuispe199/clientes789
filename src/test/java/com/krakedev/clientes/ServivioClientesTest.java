package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Clientes;
import com.krakedev.clientes.servicis.ServivioClientes;

public class ServivioClientesTest {

    private ServivioClientes servicio;

    @BeforeEach
    public void setUp() {
        // Inicializamos una nueva instancia antes de cada prueba para aislar los tests
        servicio = new ServivioClientes();
    }

    @Test
    public void testCrearClienteExitoso() {
        Clientes cliente = new Clientes();
        cliente.setCedula("1712345678");
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan.perez@email.com"); // Atributo email añadido

        Clientes resultado = servicio.crear(cliente);

        assertNotNull(resultado);
        assertEquals(1, servicio.lista().size());
        assertEquals("Juan Pérez", servicio.lista().get(0).getNombre());
        assertEquals("juan.perez@email.com", servicio.lista().get(0).getEmail()); // Verificación del email
    }

    @Test
    public void testCrearClienteDuplicado() {
        Clientes cliente1 = new Clientes();
        cliente1.setCedula("1712345678");
        cliente1.setNombre("Juan Pérez");
        cliente1.setEmail("juan.perez@email.com");

        servicio.crear(cliente1);

        Clientes cliente2 = new Clientes();
        cliente2.setCedula("1712345678");
        cliente2.setNombre("Carlos López");
        cliente2.setEmail("carlos.lopez@email.com");

        Clientes resultado = servicio.crear(cliente2);

        assertNull(resultado);
        assertEquals(1, servicio.lista().size());
        assertEquals("juan.perez@email.com", servicio.lista().get(0).getEmail()); // Se mantiene el original
    }
}