package com.malexj.service;

import com.malexj.exception.ImageNotAvailableException;
import com.malexj.model.dto.ImageAllDTO;
import com.malexj.model.dto.ImageIdAndNameDTO;
import com.malexj.model.entity.ImageEntity;

import java.util.List;

public interface ImageService {

    //DTO
    void saveDTO(ImageAllDTO image);

    List<ImageIdAndNameDTO> findDTO();

    ImageAllDTO findOneDTO(Long id);

    List<ImageIdAndNameDTO> findByIsAvailableDTO(boolean available);

    //Image
    ImageEntity save(ImageEntity entity);

    ImageEntity update(ImageEntity entity);

    void delete(Long id) throws ImageNotAvailableException;

    ImageEntity findOne(Long id);

    ImageEntity findByName(String name);

    List<ImageEntity> findAll();
}
