package com.munievents.munievents.service;

import com.munievents.munievents.entity.Noticia;
import com.munievents.munievents.repository.INoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    INoticiaRepository noticiaRepository;

    //TODO: retornamos todos los eventos
    @GetMapping
    public List<Noticia> getNoticia() {
        return noticiaRepository.findAll();
    }

    //TODO: buscamos un evento por su id
    @GetMapping
    public Optional<Noticia> getNoticia(Long id) {
        return noticiaRepository.findById(id);
    }
   
    //TODO:guarda o actualiza el evento
    @PostMapping
    public void saveOrUpdate(@RequestBody Noticia noticiaId) {
        noticiaRepository.save(noticiaId);
    }


    //TODO: elimina un evento por su id
    public void delete(Long id) {
        noticiaRepository.deleteById(id);
    }

}
