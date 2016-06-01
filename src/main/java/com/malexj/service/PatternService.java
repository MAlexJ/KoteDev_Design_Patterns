package com.malexj.service;

import com.malexj.model.dto.PatternDTO;
import com.malexj.model.dto.PatternIdAndTitleDTO;
import com.malexj.model.entity.PatternEntity;
import com.malexj.model.enums.PatternTag;
import com.malexj.model.vo.PatternAllVO;

import java.util.List;

public interface PatternService {

    //DTO
    void saveDTO(PatternDTO pattern);

    List<PatternIdAndTitleDTO> findAllDTO(PatternTag tag);

    //VO
    PatternAllVO findOneVO(Long id);

    // Pattern
    PatternEntity save(PatternEntity entity);

    PatternEntity update(PatternEntity entity);

    void delete(Long id);

    PatternEntity findOne(Long id);

    List<PatternEntity> findAll();


}
