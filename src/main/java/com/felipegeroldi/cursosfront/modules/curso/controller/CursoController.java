package com.felipegeroldi.cursosfront.modules.curso.controller;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.felipegeroldi.cursosfront.modules.curso.dto.CreateCursoDTO;
import com.felipegeroldi.cursosfront.modules.curso.dto.CursoDTO;
import com.felipegeroldi.cursosfront.modules.curso.usecases.CreateCursoUseCase;
import com.felipegeroldi.cursosfront.modules.curso.usecases.GetAllCursosUseCase;
import com.felipegeroldi.cursosfront.modules.curso.usecases.GetCursoUseCase;
import com.felipegeroldi.cursosfront.modules.curso.usecases.UpdateCursoUseCase;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private CreateCursoUseCase createCursoUseCase;
    private GetAllCursosUseCase getAllCursosUseCase;
    private GetCursoUseCase getCursoUseCase;
    private UpdateCursoUseCase updateCursoUseCase;

    public CursoController(CreateCursoUseCase createCursoUseCase,
                           GetAllCursosUseCase getAllCursosUseCase,
                           GetCursoUseCase getCursoUseCase,
                           UpdateCursoUseCase updateCursoUseCase) {
        this.createCursoUseCase = createCursoUseCase;
        this.getAllCursosUseCase = getAllCursosUseCase;
        this.getCursoUseCase = getCursoUseCase;
        this.updateCursoUseCase = updateCursoUseCase;
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

        return "redirect:/cursos/list";
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

    @GetMapping("/edit/{cursoId}")
    public String edit(@PathVariable UUID cursoId, Model model) {
        try {
            CursoDTO curso = getCursoUseCase.execute(cursoId);
            model.addAttribute("curso", curso);
        } catch (HttpClientErrorException e) {
            System.out.println(e);
        }

        return "cursos/edit";
    }

    @PostMapping("/edit")
    public String editSave(CursoDTO cursoDTO, Model model) {
        try {
            updateCursoUseCase.execute(cursoDTO);
        } catch (HttpClientErrorException e) {
            System.out.println(e);
        }

        return "redirect:/cursos/list";
    }
}
