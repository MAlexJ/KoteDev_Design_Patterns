package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;
import com.malexj.model.enums.PageType;

public class PageDTO extends BaseDTO {
    private String text;
    private PageType type;

    public PageDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PageType getType() {
        return type;
    }

    public void setType(PageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageDTO pageDTO = (PageDTO) o;
        return text != null ? text.equals(pageDTO.text) : pageDTO.text == null
                && type == pageDTO.type;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "text='" + text + '\'' +
                ", type=" + type +
                '}';
    }
}
