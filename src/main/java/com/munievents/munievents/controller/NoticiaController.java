package com.munievents.munievents.controller;

import org.springframework.web.bind.annotation.RestController;
import com.munievents.munievents.entity.News;
import com.munievents.munievents.service.NoticiaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api/v1")
public class NoticiaController {


    @Autowired
    private final NoticiaService noticiaService;
    
    //Se agrega el metodo constructor inicilizando el noticiaService
    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }


    //Nos lee todas las noticias
    @GetMapping("/noticia")
    public List<News> getNoticia() {
        return noticiaService.getNoticia();
    }

    //Para buscar una noticia por su id
    @GetMapping("/noticia/{idNoticia}")
    public Optional<News> getNoticia(@PathVariable("idNoticia") Long id) {
        return noticiaService.getNoticia(id);
    }

    //Para guardar informacion
    @PostMapping("/noticia")
    public String saveEvent(@RequestBody News noticia) {
        noticiaService.saveOrUpdate(noticia);
        return "Evento creado correctamente";
    }

    //TODO: actualizamos un evento por su id
    @PutMapping("/noticia/{id}")
    public String saveUpdateNoticia(@PathVariable("id") Long noticiaId, @RequestBody News noticia) {

        String message = "";
        try {
          
            if (!noticiaService.getNoticia(noticiaId).isEmpty()) {
                noticiaService.saveOrUpdate(noticia);
                message = "Noticia actualizado correctamente";
            } else {
                message = "Noticia no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }


    //TODO: enviamos como parametros el id del evento para eliminar el vento
    @DeleteMapping("/noticia/{id}")
    public String delete(@PathVariable("id") Long noticiaId) {
        noticiaService.delete(noticiaId);
        return "Noticia eliminado correctamente";

    }
}

