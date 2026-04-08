package ual.hmis.sesion07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcesionarioTest {

    private Concesionario concesionario;
    private Coche coche1;
    private Coche coche2;
    private Coche coche3;

    @BeforeEach
    void setUp() {
        concesionario = new Concesionario("AutoUAL");
        coche1 = new Coche("Toyota", "Corolla", 2019, 18000);
        coche2 = new Coche("BMW", "Serie 3", 2022, 45000);
        coche3 = new Coche("Seat", "Ibiza", 2021, 15000);
    }

    @Test
    void testNombreConcesionario() {
        assertEquals("AutoUAL", concesionario.getNombre());
    }

    @Test
    void testAddCoche() {
        concesionario.addCoche(coche1);
        assertEquals(1, concesionario.numCoches());
    }

    @Test
    void testAddCocheNulo() {
        assertThrows(IllegalArgumentException.class, () -> concesionario.addCoche(null));
    }

    @Test
    void testNumCoches() {
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        assertEquals(2, concesionario.numCoches());
    }

    @Test
    void testGetCocheMasBarato() {
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        concesionario.addCoche(coche3);
        assertEquals(coche3, concesionario.getCocheMasBarato());
    }

    @Test
    void testGetCocheMasBaratoListaVacia() {
        assertNull(concesionario.getCocheMasBarato());
    }

    @Test
    void testGetCochesNuevos() {
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        concesionario.addCoche(coche3);
        assertEquals(2, concesionario.getCochesNuevos().size());
    }

    @Test
    void testEsNuevo() {
        assertFalse(coche1.esNuevo());
        assertTrue(coche2.esNuevo());
    }

    @Test
    void testSetPrecioValido() {
        coche1.setPrecio(20000);
        assertEquals(20000, coche1.getPrecio());
    }

    @Test
    void testSetPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> coche1.setPrecio(-100));
    }

    @Test
    void testToString() {
        assertEquals("Toyota Corolla (2019) - 18000.0€", coche1.toString());
    }

    @Test
    void testGetMarca() {
        assertEquals("Toyota", coche1.getMarca());
    }

    @Test
    void testGetModelo() {
        assertEquals("Corolla", coche1.getModelo());
    }

    @Test
    void testGetAnio() {
        assertEquals(2019, coche1.getAnio());
    }
    @Test
    void testGetCoches() {
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        assertFalse(concesionario.getCoches().isEmpty());
        assertEquals(2, concesionario.getCoches().size());
    }
}