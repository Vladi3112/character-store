package com.ejemplo.characterstore.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RICKANDMORTY")
public class PersonajeRickAndMorty extends Producto {

    @Column(length = 40)
    private String especie;

    @Column(length = 40)
    private String estado;

    @Column(length = 40)
    private String genero;

    @Column(length = 120)
    private String origen;

    public PersonajeRickAndMorty() {}

    @Override
    public String getDescripcionVenta() {
        String texto = (especie == null || especie.isBlank())
                ? "Ser interdimensional"
                : especie;
        return getNombre() + " - " + texto;
    }

    public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
    public String getAtributoPrincipal() {
        return (origen == null || origen.isBlank())
                ? "Origen desconocido"
                : "Origen: " + origen;
    }

    // Generar getters y setters.
}