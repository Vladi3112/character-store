package com.ejemplo.characterstore.dto.rickandmorty;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMortyPageDto {
    private InfoDto info;
    public InfoDto getInfo() {
		return info;
	}

	public void setInfo(InfoDto info) {
		this.info = info;
	}

	public List<RickAndMortyCharacterDto> getResults() {
		return results;
	}

	public void setResults(List<RickAndMortyCharacterDto> results) {
		this.results = results;
	}

	private List<RickAndMortyCharacterDto> results;

    // Getters y setters.

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InfoDto {
        private Integer count;
        public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Integer getPages() {
			return pages;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public String getNext() {
			return next;
		}
		public void setNext(String next) {
			this.next = next;
		}
		public String getPrev() {
			return prev;
		}
		public void setPrev(String prev) {
			this.prev = prev;
		}
		private Integer pages;
        private String next;
        private String prev;
        // Getters y setters.
    }
}
