package com.felipegeroldi.cursosfront.modules.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateCursoDTO {
    private String name;
    private String category;
    private String status;
    private String professor;
}
