package com.felipegeroldi.cursosfront.modules.curso.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.felipegeroldi.cursosfront.modules.curso.dto.CursoDTO;

@Service
public class GetCursoUseCase {
    @Value("${backend.url}")
    private String backendUrl;

    public CursoDTO execute(UUID cursoId) {
        var rt = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String endpoint = backendUrl.concat("/cursos/" + cursoId.toString());
        return rt.getForObject(endpoint, CursoDTO.class);
    }
}
