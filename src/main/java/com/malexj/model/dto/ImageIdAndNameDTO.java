package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;

public class ImageIdAndNameDTO extends BaseDTO {
    private Long id;
    private String name;

    public ImageIdAndNameDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageIdAndNameDTO that = (ImageIdAndNameDTO) o;
        return id != null ? id.equals(that.id) : that.id == null
                && (name != null ? name.equals(that.name) : that.name == null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
