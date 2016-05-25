package com.malexj.repository;

import com.malexj.model.entity.PageEntity;
import com.malexj.model.enums.PageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PageRepository extends JpaRepository<PageEntity, Long> {

    @Query("SELECT p.type FROM PageEntity p")
    List<PageType> findType();

}
