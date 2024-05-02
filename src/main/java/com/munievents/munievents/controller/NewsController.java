package com.munievents.munievents.controller;

import org.springframework.web.bind.annotation.*;
import com.munievents.munievents.entity.News;
import com.munievents.munievents.service.NewsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:8080"})
public class NewsController {

    @Autowired
    private final NewsService newsService;
    
    //TODO:Se agrega el metodo constructor inicilizando el noticiaService
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    //TODO: Nos lee todas las noticias
    @GetMapping("/news")
    public List<News> getNews() {
        return newsService.getNews();
    }

    //TODO: Para buscar una noticia por su id
    @GetMapping("/news/{idNews}")
    public Optional<News> getNews(@PathVariable("idNews") int id) {
        return newsService.getNews(id);
    }

    //TODO:Para guardar informacion
    @PostMapping("/news")
    public String saveNews(@RequestBody News news) {
        newsService.saveOrUpdate(news);
        return "Noticia creada correctamente";
    }

    //TODO: actualizamos un evento por su id
    @PutMapping("/news/{id}")
    public String saveUpdateNews(@PathVariable("id") int newsId, @RequestBody News news) {

        String message = "";
        try {
          
            if (newsService.getNews(newsId).isPresent()) {
                newsService.saveOrUpdate(news);
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
    @DeleteMapping("/news/{id}")
    public String delete(@PathVariable("id") int newsId) {
        newsService.delete(newsId);
        return "Noticia eliminado correctamente";

    }
}

