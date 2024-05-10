//FUTURA IMPLEMENTACION
//package com.munievents.munievents.controller;
//
//
//import com.munievents.munievents.entity.Event;
//import com.munievents.munievents.entity.Reviews;
//import com.munievents.munievents.service.ReviewsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path = "/api/v1")
//public class ReviewsController {
//
//    @Autowired
//    private final ReviewsService reviewsService;
//
//    public ReviewsController(ReviewsService reviewsService) {
//        this.reviewsService = reviewsService;
//    }
//
//    //TODO: obtenemos todos los eventos
//    @GetMapping("/reviews")
//    public List<Reviews> getAll() {
//        return reviewsService.getReviews();
//    }
//
//    @GetMapping("/reviews/{idReview}/")
//    public Optional<Reviews> getById(@PathVariable("idReview") int idReview) {
//        return reviewsService.getReviewById(idReview);
//    }
//
//
//    //TODO: enviamos el body un nuevo evento
//    @PostMapping("/reviews")
//    public String saveReview(@RequestBody Reviews reviews) {
//        reviewsService.saveOrUpdate(reviews);
//        return "Evento creado correctamente";
//    }
//
//    //TODO: actualizamos un evento por su id
//    @PutMapping("/reviews/{id}")
//    public String saveUpdateEvent(@PathVariable("id") int reviewId, @RequestBody Reviews reviews) {
//
//        String message = "";
//        try {
//            if (reviewsService.getReviewById(reviewId).isPresent()) {
//                reviewsService.saveOrUpdate(reviews);
//                message = "Review actualizado correctamente";
//            } else {
//                message = "Review no existe";
//            }
//        } catch (Exception ex) {
//            message = ex.getMessage();
//        }
//        return message;
//    }
//
//
//    //TODO: enviamos como parametros el id del evento para eliminar el vento
//    @DeleteMapping("/reviews/{id}")
//    public String delete(@PathVariable("id") int reviewId) {
//        reviewsService.delete(reviewId);
//        return "Review eliminada correctamente";
//    }
//
//}
