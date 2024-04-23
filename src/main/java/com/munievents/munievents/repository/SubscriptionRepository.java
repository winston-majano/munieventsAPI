package com.munievents.munievents.repository;

import com.munievents.munievents.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    
}
