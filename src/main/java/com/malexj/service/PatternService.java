package com.malexj.service;

import com.malexj.model.dto.PatternAllDTO;
import com.malexj.model.entity.PatternEntity;

import java.util.List;

public interface PatternService {

    //DTO
    void saveDTO(PatternAllDTO pattern);

    // Pattern
    PatternEntity save(PatternEntity entity);

    PatternEntity update(PatternEntity entity);

    void delete(Long id);

    PatternEntity findOne(Long id);

    List<PatternEntity> findAll();

}
