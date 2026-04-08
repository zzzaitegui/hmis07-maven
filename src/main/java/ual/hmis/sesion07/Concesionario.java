package ual.hmis.sesion07;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un concesionario de coches.
 */
public final class Concesionario {

    /** Nombre del concesionario. */
    private final String nombre;
    /** Lista de coches del concesionario. */
    private final List<Coche> coches;

    /**
     * Constructor de Concesionario.
     * @param nombreParam nombre del concesionario
     */
    public Concesionario(final String nombreParam) {
        this.nombre = nombreParam;
        this.coches = new ArrayList<>();
    }

    /**
     * Devuelve el nombre
     * @return el nombre del concesionario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Añade un coche al concesionario.
     * @param coche coche a añadir, no puede ser nulo
     */
    public void addCoche(final Coche coche) {
        if (coche == null) {
            throw new IllegalArgumentException("El coche no puede ser nulo");
        }
        coches.add(coche);
    }

    /**
     * Devuelve los coches
     * @return copia de la lista de coches del concesionario
     */
    public List<Coche> getCoches() {
        return new ArrayList<>(coches);
    }

    /**
     * Devuelve el número de coches
     * @return número de coches en el concesionario
     */
    public int numCoches() {
        return coches.size();
    }

    /**
     * Devuelve el coche más barato del concesionario.
     * @return el coche con menor precio, o null si no hay coches
     */
    public Coche getCocheMasBarato() {
        Coche masBarato = null;
        if (!coches.isEmpty()) {
            masBarato = coches.get(0);
            for (final Coche c : coches) {
                if (c.getPrecio() < masBarato.getPrecio()) {
                    masBarato = c;
                }
            }
        }
        return masBarato;
    }

    /**
     * Devuelve la lista de coches nuevos (año >= 2020).
     * @return lista de coches nuevos
     */
    public List<Coche> getCochesNuevos() {
        final List<Coche> nuevos = new ArrayList<>();
        for (final Coche c : coches) {
            if (c.esNuevo()) {
                nuevos.add(c);
            }
        }
        return nuevos;
    }
}
