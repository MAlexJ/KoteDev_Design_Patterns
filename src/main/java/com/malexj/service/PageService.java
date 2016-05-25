package com.malexj.service;

import com.malexj.model.dto.PageAllDTO;
import com.malexj.model.dto.PageDTO;
import com.malexj.model.dto.PageIdAndTypeDTO;
import com.malexj.model.entity.PageEntity;
import com.malexj.model.enums.PageType;

import java.util.List;

public interface PageService {


    // DTO
    List<PageType> findType();

    PageDTO saveDTO(PageDTO entityDTO);

    PageAllDTO findDTO(Long id);

    List<PageIdAndTypeDTO> findAllIdAndTypeDTO();

    void updateDTO(PageAllDTO page);

    // Entity
    PageEntity save(PageEntity entity);

    PageEntity update(PageEntity entity);

    void delete(Long id);

    PageEntity find(Long id);

    List<PageEntity> findAll();

}
