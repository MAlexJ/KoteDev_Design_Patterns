package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;
import com.malexj.model.enums.PageType;

public class PageIdAndTypeDTO extends BaseDTO {
    private Long id;
    private PageType type;

    public PageIdAndTypeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        PageIdAndTypeDTO that = (PageIdAndTypeDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageIdAndTypeDTO{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
