package com.munievents.munievents.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munievents.munievents.entity.Subscription;
import com.munievents.munievents.service.SubscriptionService;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*")
@Tag(name = "Subscription Controller")
public class SubscriptionController {
    
    @Autowired
    private final SubscriptionService subscripService;

    public SubscriptionController(SubscriptionService subscripService) {
        this.subscripService = subscripService;
    }

    @GetMapping("/subscriptions")
    public List<Subscription> getAll() {
        return subscripService.getSubscriptions();
    }

    @GetMapping("/subscriptions/{idSubscrip}")
    public Optional<Subscription> getById(@PathVariable("idSubscrip") int subscripId) {
        return subscripService.getSubscription(subscripId);
    }

    @PostMapping("/subscriptions")
    public String saveSubscription(@RequestBody Subscription subscription) {
        subscripService.saveOrUpdate(subscription);
        return "Subscripcion creada correctamente";
    }

    @PutMapping("/subscriptions/{id}")
    public String updateSubscription(@PathVariable("id") int subscripId, @RequestBody Subscription subscription) {
        String message = "";
        try {
            if (subscripService.getSubscription((int) subscripId).isPresent()) {
               // subscription.setPlan_id(subscripId);
                subscripService.saveOrUpdate(subscription);
                message = "Subscripcion actualizada correctamente";
            } else {
                message = "Subscripcion no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }

    @DeleteMapping("/subscriptions/{id}")
    public String deleteSubscripcion(@PathVariable("id") int subscripId) {
        subscripService.delete(subscripId);
        return "Subscripcion eliminada correctamente";
    }
}
