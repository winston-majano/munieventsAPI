//package com.munievents.munievents.service;
//
//import com.munievents.munievents.entity.Event;
//import com.munievents.munievents.entity.Reviews;
//import com.munievents.munievents.repository.ReviewsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ReviewsService {
//    @Autowired
//    ReviewsRepository  reviewsRepository;
//
//    //TODO: retornamos todas las reviews
//    public List<Reviews> getReviews() {
//        return reviewsRepository.findAll();
//    }
//
//    //TODO: buscamos una review por su id
//    public Optional<Reviews> getReviewById(int id) {
//        return reviewsRepository.findById(id);
//    }
//
//    //TODO:guarda o actualiza una review
//    @PostMapping
//    public void saveOrUpdate(@RequestBody Reviews reviews) {
//        reviewsRepository.save(reviews);
//    }
//
//
//    //TODO: elimina una review poor su id
//    public void delete(int id) {
//        reviewsRepository.deleteById(id);
//    }
//
//}
