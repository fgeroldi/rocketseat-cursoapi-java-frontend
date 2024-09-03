package com.felipegeroldi.cursosfront.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.felipegeroldi.cursosfront.modules.curso.dto.CursoDTO;

@Service
public class UpdateCursoUseCase {
    @Value("${backend.url}")
    private String backendUrl;

    public void execute(CursoDTO cursoDTO) {
        var rt = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String endpoint = backendUrl.concat("/cursos/" + cursoDTO.getId().toString());
        rt.put(endpoint, cursoDTO);
    }
}
