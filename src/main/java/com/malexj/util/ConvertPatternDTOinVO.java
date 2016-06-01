package com.malexj.util;

import com.malexj.model.dto.PatternAllDTO;
import com.malexj.model.entity.ImageEntity;
import com.malexj.model.entity.PatternEntity;
import com.malexj.model.vo.PatternAllVO;
import org.springframework.stereotype.Component;

@Component
public class ConvertPatternDTOinVO {

    public PatternAllVO convertDTOinVO(PatternEntity entity) {
        PatternAllVO vo;
        if (entity != null) {
            vo = new PatternAllVO();
            vo.setId(entity.getId());
            vo.setText(entity.getText());
            vo.setTag(entity.getTag());
            vo.setTitle(entity.getTitle());
            vo.setImage(entity.getImage().getName());
        } else {
            vo = new PatternAllVO();
            vo.setId(0L);
            vo.setText("Default");
            vo.setTag(null);
            vo.setTitle("Default");
            vo.setImage("Default");
        }
        return vo;
    }

    public PatternAllDTO convertDTO(PatternEntity entity) {
        PatternAllDTO dto;
        if (entity != null) {
            dto = new PatternAllDTO();
            dto.setId(entity.getId());
            dto.setText(entity.getText());
            dto.setTag(entity.getTag());
            dto.setTitle(entity.getTitle());
            dto.setImage(entity.getImage());
        } else {
            dto = new PatternAllDTO();
            dto.setId(0L);
            dto.setText("Default");
            dto.setTag(null);
            dto.setTitle("Default");
            dto.setImage(new ImageEntity());
        }
        return dto;
    }

}
