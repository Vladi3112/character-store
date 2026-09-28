package com.ejemplo.characterstore.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ejemplo.characterstore.dto.rickandmorty.*;
import com.ejemplo.characterstore.model.PersonajeRickAndMorty;
import com.ejemplo.characterstore.repository.ProductoRepository;

@Service
public class RickAndMortyMigrationService {

    private static final String UNIVERSO = "RICKANDMORTY";

    private final RickAndMortyApiService apiService;
    private final ProductoRepository repository;

    public RickAndMortyMigrationService(
            RickAndMortyApiService apiService,
            ProductoRepository repository) {
        this.apiService = apiService;
        this.repository = repository;
    }

    @Transactional
    public int migrarTodos() {
        int insertados = 0;
        int pagina = 1;
        int totalPaginas;

        do {
            RickAndMortyPageDto respuesta = apiService.obtenerPagina(pagina);
            if (respuesta == null || respuesta.getResults() == null) {
                break;
            }

            totalPaginas = (respuesta.getInfo() == null
                    || respuesta.getInfo().getPages() == null)
                    ? pagina
                    : respuesta.getInfo().getPages();

            for (RickAndMortyCharacterDto dto : respuesta.getResults()) {
                if (dto.getId() == null) continue;

                boolean existe = repository
                    .existsByUniversoAndApiId(UNIVERSO, dto.getId());

                if (!existe) {
                    repository.save(convertir(dto));
                    insertados++;
                }
            }

            System.out.println("Rick and Morty página " + pagina
                    + " de " + totalPaginas + " procesada");
            pagina++;

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } while (pagina <= totalPaginas);

        return insertados;
    }

    private PersonajeRickAndMorty convertir(RickAndMortyCharacterDto dto) {
        PersonajeRickAndMorty p = new PersonajeRickAndMorty();
        p.setApiId(dto.getId());
        p.setNombre(dto.getName());
        p.setUniverso(UNIVERSO);
        p.setEspecie(dto.getSpecies());
        p.setEstado(dto.getStatus());
        p.setGenero(dto.getGender());

        if (dto.getOrigin() != null) {
            p.setOrigen(dto.getOrigin().getName());
        }

        p.setImagen(dto.getImage());
        p.setPrecio(precioDidactico(dto.getId()));
        p.setStock(5 + (dto.getId() % 21));
        return p;
    }

    private BigDecimal precioDidactico(int apiId) {
        double valor = 14.99 + ((apiId % 12) * 1.50);
        return BigDecimal.valueOf(valor);
    }
}