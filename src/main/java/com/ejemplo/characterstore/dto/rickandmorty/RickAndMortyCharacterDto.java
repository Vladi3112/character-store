package com.ejemplo.characterstore.dto.rickandmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMortyCharacterDto {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;
    private OrigenDto origin;

    // Getters y setters.

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrigenDto {
        private String name;
        // Getters y setters.

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public OrigenDto getOrigin() {
		return origin;
	}

	public void setOrigin(OrigenDto origin) {
		this.origin = origin;
	}
}