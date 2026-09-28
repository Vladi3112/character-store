package com.ejemplo.characterstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.ejemplo.characterstore.dto.rickandmorty.RickAndMortyPageDto;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService() {
        this.restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();
    }

    public RickAndMortyPageDto obtenerPagina(int pagina) {
        return restClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/character")
                .queryParam("page", pagina)
                .build())
            .retrieve()
            .body(RickAndMortyPageDto.class);
    }
}
