package com.malexj.service.impl;

import com.malexj.model.dto.PatternAllDTO;
import com.malexj.model.dto.PatternDTO;
import com.malexj.model.dto.PatternIdAndTitleDTO;
import com.malexj.model.entity.PatternEntity;
import com.malexj.model.enums.PatternTag;
import com.malexj.model.vo.PatternAllVO;
import com.malexj.repository.PatternRepository;
import com.malexj.service.PatternService;
import com.malexj.util.ConvertPatternDTOinVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatternServiceImpl implements PatternService {

    @Autowired
    private PatternRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Autowired
    private ConvertPatternDTOinVO convert;

    @Override
    public void saveDTO(PatternDTO pattern) {
        save(beanMapper.map(pattern, PatternEntity.class));
    }

    @Override
    public List<PatternIdAndTitleDTO> findDTO(PatternTag tag) {
        List<PatternIdAndTitleDTO> dtoList = new ArrayList<>();
        List<PatternEntity> patternList = repository.findAllByTag(tag);
        for(PatternEntity item: patternList){
            dtoList.add(beanMapper.map(item, PatternIdAndTitleDTO.class));
        }
        return dtoList;
    }

    @Override
    public List<PatternAllDTO> findAllDTO(PatternTag tag) {
        List<PatternAllDTO> dtoList = new ArrayList<>();
        List<PatternEntity> patternList = repository.findAllByTag(tag);
        for(PatternEntity item: patternList){
            dtoList.add(convert.convertDTO(item));
        }
        return dtoList;
    }

    @Override
    public PatternAllVO findOneVO(Long id) {
        return convert.convertDTOinVO(findOne(id));
    }

    @Override
    public PatternEntity save(PatternEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public PatternEntity update(PatternEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public PatternEntity findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<PatternEntity> findAll() {
        return repository.findAll();
    }
}
