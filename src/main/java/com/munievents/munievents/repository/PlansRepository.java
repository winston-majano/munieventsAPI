package com.munievents.munievents.repository;

import org.springframework.stereotype.Repository;
import com.munievents.munievents.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PlansRepository extends JpaRepository<Plans, Integer>{
    
}
