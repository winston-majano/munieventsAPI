package com.munievents.munievents.controller;



import com.munievents.munievents.entity.Photos;
import com.munievents.munievents.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class PhotosController {

    @Autowired
    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    //TODO: obtenemos todas las fotos
    @GetMapping("/photos")
    public List<Photos> getAll() {
        return photosService.getPhotos();
    }
}
