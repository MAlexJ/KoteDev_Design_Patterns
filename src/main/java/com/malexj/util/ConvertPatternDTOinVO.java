package com.malexj.util;

import com.malexj.model.entity.PatternEntity;
import com.malexj.model.vo.PatternAllVO;
import org.springframework.stereotype.Component;

@Component
public class ConvertPatternDTOinVO {

    public PatternAllVO convertDTOinVO(PatternEntity entity) {
        PatternAllVO vo = new PatternAllVO();
        vo.setId(entity.getId());
        vo.setText(entity.getText());
        vo.setTag(entity.getTag());
        vo.setTitle(entity.getTitle());
        vo.setImage(entity.getImage().getName());
        return vo;
    }

}
