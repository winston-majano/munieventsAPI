package com.munievents.munievents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.munievents.munievents.entity.News;


    @Repository
    public interface INoticiaRepository extends JpaRepository<News, Long> {
        
    }
