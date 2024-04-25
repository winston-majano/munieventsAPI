 package com.munievents.munievents.service;



 import com.munievents.munievents.entity.Photos;
 import com.munievents.munievents.repository.PhotosRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;

 import java.util.List;
 import java.util.Optional;

 @Service
 public class PhotosService {
     @Autowired
     PhotosRepository   photosRepository;

     //TODO: retornamos todas las fotos
     public List<Photos> getPhotos() {

         System.out.println(photosRepository.findAll());
         return photosRepository.findAll();
     }

     //TODO: buscamos una foto por su id
     public Optional<Photos> getPhotos(Long id) {
         return photosRepository.findById(id);
     }

     //TODO:guarda o actualiza foto
     @PostMapping
     public void saveOrUpdate(@RequestBody Photos photos) {
         photosRepository.save(photos);
     }


     //TODO: elimina una foto por su id
     public void delete(Long id) {
         photosRepository.deleteById(id);
     }


 }
