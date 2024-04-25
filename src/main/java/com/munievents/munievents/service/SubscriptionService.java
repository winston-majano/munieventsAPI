package com.munievents.munievents.service;

import java.util.List;
import java.util.Optional;

import com.munievents.munievents.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.munievents.munievents.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    // TODO: retornamos todos los eventos
    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // TODO: buscamos un evento por su id
    public Optional<Subscription> getSubscription(Long subscripId) {
        return subscriptionRepository.findById(subscripId);
    }

    // TODO:guarda o actualiza el subscripcion
    @PostMapping
    public void saveOrUpdate(@RequestBody Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    // TODO: elimina un subscripcion por su id
    public void delete(Long subscripId) {
        subscriptionRepository.deleteById(subscripId);
    }
}
