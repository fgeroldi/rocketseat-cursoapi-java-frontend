package com.felipegeroldi.cursosfront.modules.curso.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.felipegeroldi.cursosfront.modules.curso.dto.CreateCursoDTO;
import com.felipegeroldi.cursosfront.modules.curso.dto.CursoDTO;
import com.felipegeroldi.cursosfront.modules.curso.usecases.CreateCursoUseCase;
import com.felipegeroldi.cursosfront.modules.curso.usecases.GetAllCursosUseCase;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    public CreateCursoUseCase createCursoUseCase;
    public GetAllCursosUseCase getAllCursosUseCase;

    public CursoController(CreateCursoUseCase createCursoUseCase,
                           GetAllCursosUseCase getAllCursosUseCase) {
        this.createCursoUseCase = createCursoUseCase;
        this.getAllCursosUseCase = getAllCursosUseCase;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("curso", new CreateCursoDTO());

        return "cursos/create";
    }

    @PostMapping("/create")
    public String save(Model model, CreateCursoDTO createCursoDTO) {
        try {
            createCursoUseCase.execute(createCursoDTO);
        } catch (HttpClientErrorException e) {
            System.out.println(e);
        }

        return "redirect:/cursos/create";
    }

    @GetMapping("/list")
    public String list(Model model) {
        try {
            CursoDTO[] cursos = getAllCursosUseCase.execute();
            model.addAttribute("cursos", Arrays.asList(cursos));
        } catch (HttpClientErrorException e) {
            System.out.println(e);
        }

        return "cursos/list";
    }
}
