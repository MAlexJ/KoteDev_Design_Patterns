package com.malexj.service.impl;

import com.malexj.model.dto.ImageAllDTO;
import com.malexj.model.dto.ImageIdAndNameDTO;
import com.malexj.model.entity.ImageEntity;
import com.malexj.repository.ImageRepository;
import com.malexj.service.ImageService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public void saveDTO(ImageAllDTO image) {
        save(beanMapper.map(image, ImageEntity.class));
    }

    @Override
    public List<ImageIdAndNameDTO> findDTO() {
        List<ImageIdAndNameDTO> dtoList = new ArrayList<>();
        List<ImageEntity> imageList = findAll();
        for (ImageEntity entity : imageList) {
            dtoList.add(beanMapper.map(entity, ImageIdAndNameDTO.class));
        }
        return dtoList;
    }

    @Override
    public ImageAllDTO findOneDTO(Long id) {
        return beanMapper.map(findOne(id), ImageAllDTO.class);
    }

    @Override
    public List<ImageIdAndNameDTO> findByIsAvailableDTO(boolean available) {
        List<ImageIdAndNameDTO> dtoList = new ArrayList<>();
        List<ImageEntity> imageList = repository.findByIsAvailable(available);
        for (ImageEntity entity : imageList) {
            dtoList.add(beanMapper.map(entity, ImageIdAndNameDTO.class));
        }
        return dtoList;
    }

    @Override
    public ImageEntity save(ImageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public ImageEntity update(ImageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ImageEntity findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<ImageEntity> findAll() {
        return repository.findAll();
    }
}
