package com.malexj.service.impl;

import com.malexj.model.dto.PageAllDTO;
import com.malexj.model.dto.PageDTO;
import com.malexj.model.dto.PageIdAndTypeDTO;
import com.malexj.model.entity.PageEntity;
import com.malexj.model.enums.PageType;
import com.malexj.repository.PageRepository;
import com.malexj.service.PageService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public List<PageType> findType() {
        return repository.findType();
    }


    @Override
    public PageDTO saveDTO(PageDTO entityDTO) {
        PageEntity entity = beanMapper.map(entityDTO, PageEntity.class);
        return beanMapper.map(save(entity), PageDTO.class);
    }

    @Override
    public PageAllDTO findDTO(Long id) {
        return beanMapper.map(find(id), PageAllDTO.class);
    }

    @Override
    public List<PageIdAndTypeDTO> findAllIdAndTypeDTO() {
        List<PageIdAndTypeDTO> result = new ArrayList<>();
        for(PageEntity entity:findAll()){
            result.add(beanMapper.map(entity, PageIdAndTypeDTO.class));
        }
        return result;
    }

    @Override
    public void updateDTO(PageAllDTO page) {
        save(beanMapper.map(page, PageEntity.class));
    }

    @Override
    public PageAllDTO findPageDTO(PageType type) {

        return beanMapper.map(repository.findByType(type), PageAllDTO.class);
    }

    @Override
    public PageEntity save(PageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public PageEntity update(PageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public PageEntity find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<PageEntity> findAll() {
        return repository.findAll();
    }


}
