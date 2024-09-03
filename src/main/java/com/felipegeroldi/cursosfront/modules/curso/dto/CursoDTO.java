package com.felipegeroldi.cursosfront.modules.curso.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private UUID id;
    private String name;
    private String category;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
