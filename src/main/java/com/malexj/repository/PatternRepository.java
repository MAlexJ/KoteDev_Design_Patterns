package com.malexj.repository;

import com.malexj.model.entity.PatternEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternRepository extends JpaRepository<PatternEntity, Long> {
}
