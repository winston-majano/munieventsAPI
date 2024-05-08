//package com.munievents.munievents.controller;
//
//
//
//import com.munievents.munievents.entity.Photos;
//import com.munievents.munievents.entity.Reviews;
//import com.munievents.munievents.service.PhotosService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RequestMapping(path = "/api/v1")
//@RestController
//@CrossOrigin(origins = {"http://localhost:5173","http://localhost:8080"})
//public class PhotosController {
//
//    @Autowired
//    private final PhotosService photosService;
//
//    public PhotosController(PhotosService photosService) {
//        this.photosService = photosService;
//    }
//
//    //TODO: obtenemos todas las fotos
//    @GetMapping("/photos")
//    public List<Photos> getAll() {
//        return photosService.getPhotos();
//    }
//
//    @GetMapping("/photos/{idPhoto}/")
//    public Optional<Photos> getById(@PathVariable("idPhoto") int idPhoto) {
//        return photosService.getPhotos(idPhoto);
//    }
//
//
//    //TODO: enviamos el body un nuevo evento
//    @PostMapping("/photos")
//    public String saveReview(@RequestBody Photos photos) {
//        photosService.saveOrUpdate(photos);
//        return "Foto creada correctamente";
//    }
//
//    //TODO: actualizamos un evento por su id
//    @PutMapping("/photos/{id}")
//    public String saveUpdateEvent(@PathVariable("id") int photoId, @RequestBody Photos photos) {
//
//        String message = "";
//        try {
//            if (photosService.getPhotos(photoId).isPresent()) {
//                photosService.saveOrUpdate(photos);
//                message = "Foto actualizada correctamente";
//            } else {
//                message = "Foto no existe";
//            }
//        } catch (Exception ex) {
//            message = ex.getMessage();
//        }
//        return message;
//    }
//
//    @DeleteMapping("/photos/{id}")
//    public String delete(@PathVariable("id") int photoId) {
//        photosService.delete(photoId);
//        return "Foto eliminada correctamente";
//    }
//
//}
