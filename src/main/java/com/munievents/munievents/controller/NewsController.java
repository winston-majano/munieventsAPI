package com.munievents.munievents.controller;

import org.springframework.web.bind.annotation.RestController;
import com.munievents.munievents.entity.News;
import com.munievents.munievents.service.NewsService;
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
public class NewsController {


    @Autowired
    private final NewsService newsService;
    
    //Se agrega el metodo constructor inicilizando el noticiaService
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    //Nos lee todas las noticias
    @GetMapping("/news")
    public List<News> getNews() {
        return newsService.getNews();
    }

    //Para buscar una noticia por su id
    @GetMapping("/news/{idNews}")
    public Optional<News> getNews(@PathVariable("idNews") Long id) {
        return newsService.getNews(id);
    }

    //Para guardar informacion
    @PostMapping("/news")
    public String saveNews(@RequestBody News news) {
        newsService.saveOrUpdate(news);
        return "Noticia creada correctamente";
    }

    //TODO: actualizamos un evento por su id
    @PutMapping("/news/{id}")
    public String saveUpdateNews(@PathVariable("id") Long newsId, @RequestBody News news) {

        String message = "";
        try {
          
            if (!newsService.getNews(newsId).isEmpty()) {
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
    public String delete(@PathVariable("id") Long newsId) {
        newsService.delete(newsId);
        return "Noticia eliminado correctamente";

    }
}

