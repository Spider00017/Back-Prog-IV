package br.ueg.aula01.controller;

import br.ueg.aula01.model.Aluno;
import br.ueg.aula01.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listar() {
        Iterable<Aluno> findAll = alunoRepository.findAll();

        List<Aluno> alunos = new ArrayList<Aluno>();

//        forEach com lambda
//        findAll.forEach(aluno -> {
//            alunos.add(aluno);
//        });

        findAll.forEach(alunos::add);
        return alunos;
    }

    ;

    @PostMapping
    public Aluno incluir(@RequestBody Aluno aluno) {
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    @PostMapping(path = "/{id}")
    public Aluno alterar(@RequestBody Aluno aluno, @PathVariable Long id) {
        Optional<Aluno> alunoBD = alunoRepository.findById(id);
        if (!alunoBD.isPresent()) {
            throw new IllegalStateException("Aluno não existe para ID: " + id);
        }
        Aluno alunoOld = alunoBD.get();

        if (aluno.getIdade() != null) {
            alunoOld.setIdade(aluno.getIdade());
        }
        if (aluno.getPrimeiroNome() != null) {
            alunoOld.setPrimeiroNome(aluno.getPrimeiroNome());
        }
        if (aluno.getSobreNome() != null) {
            alunoOld.setSobreNome(aluno.getSobreNome());
        }

        return alunoRepository.save(alunoOld);
    }


    @DeleteMapping(path = "/{id}")
    public void remover (@PathVariable Long id) {
        Optional<Aluno> alunoBD = alunoRepository.findById(id);
        if (!alunoBD.isPresent()) {
            throw new IllegalStateException("Item não existe para ID: " + id);
        }
        alunoRepository.delete(alunoBD.get());
    }


    @GetMapping (path = "/{id}")
    public Aluno editar (@PathVariable Long id){
        Optional<Aluno> alunoBD = alunoRepository.findById(id);
        if (!alunoBD.isPresent()) {
            throw new IllegalStateException("Item não existe para ID: " + id);
        }
        return (alunoBD.get());
    }



}
