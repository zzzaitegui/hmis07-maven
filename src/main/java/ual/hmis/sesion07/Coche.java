package ual.hmis.sesion07;

/**
 * Representa un coche con marca, modelo, año y precio.
 */
public final class Coche {

    /** Marca del coche. */
    private String marca;
    /** Modelo del coche. */
    private String modelo;
    /** Año de fabricación. */
    private int anio;
    /** Precio del coche. */
    private double precio;

    /** Año a partir del cual un coche se considera nuevo. */
    private static final int ANIO_NUEVO = 2020;

    /**
     * Constructor de Coche.
     * @param marcaParam marca del coche
     * @param modeloParam modelo del coche
     * @param anioParam año de fabricación
     * @param precioParam precio del coche
     */
    public Coche(final String marcaParam, final String modeloParam,
            final int anioParam, final double precioParam) {
        this.marca = marcaParam;
        this.modelo = modeloParam;
        this.anio = anioParam;
        this.precio = precioParam;
    }

    /**
     * Devuelve la marca del coche.
     * @return la marca del coche
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve el modelo
     * @return el modelo del coche
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devuelve el año
     * @return el año del coche
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Devuelve el precio
     * @return el precio del coche
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del coche.
     * @param precioParam nuevo precio, debe ser positivo
     */
    public void setPrecio(final double precioParam) {
        if (precioParam < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo");
        }
        this.precio = precioParam;
    }

    /**
     * Indica si el coche es nuevo (año >= 2020).
     * @return true si es nuevo
     */
    public boolean esNuevo() {
        return anio >= ANIO_NUEVO;
    }

    /**
     * @return representación en texto del coche
     */
    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ") - " + precio + "€";
    }
}
