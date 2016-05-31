package com.malexj.repository;

import com.malexj.model.entity.PatternEntity;
import com.malexj.model.enums.PatternTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatternRepository extends JpaRepository<PatternEntity, Long> {

    List<PatternEntity> findAllByTag(PatternTag tag);
}
