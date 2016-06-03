package com.malexj.model.dto;


import com.malexj.model.dto.base.BaseDTO;

public class PatternIdAndTitleDTO extends BaseDTO {
    private Long id;
    private String title;

    public PatternIdAndTitleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternIdAndTitleDTO that = (PatternIdAndTitleDTO) o;
        return id != null ? id.equals(that.id) : that.id == null
                && (title != null ? title.equals(that.title) : that.title == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        return "PatternIdAndTitleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
