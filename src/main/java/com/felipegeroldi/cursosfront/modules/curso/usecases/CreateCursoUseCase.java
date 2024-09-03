package com.felipegeroldi.cursosfront.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.felipegeroldi.cursosfront.modules.curso.dto.CreateCursoDTO;

@Service
public class CreateCursoUseCase {
    @Value("${backend.url}")
    private String backendUrl;

    public void execute(CreateCursoDTO createCursoDTO) {
        var rt = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String endpoint = backendUrl.concat("/cursos");
        rt.postForObject(endpoint, createCursoDTO, String.class);
    }
}
