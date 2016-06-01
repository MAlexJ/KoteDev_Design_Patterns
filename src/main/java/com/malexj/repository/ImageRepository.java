package com.malexj.repository;

import com.malexj.model.entity.ImageEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

    List<ImageEntity> findByIsAvailable(boolean available);

    ImageEntity findByName(String name);


}
