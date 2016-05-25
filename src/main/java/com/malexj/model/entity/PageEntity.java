package com.malexj.model.entity;


import com.malexj.model.entity.base.BaseEntity;
import com.malexj.model.enums.PageType;

import javax.persistence.*;

@Entity
@Table(name = "page")
public class PageEntity extends BaseEntity {


    @Column(name = "text", nullable = false, columnDefinition="TEXT", length = 2000)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private PageType type;

    public PageEntity() {
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

        PageEntity that = (PageEntity) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "text='" + text + '\'' +
                ", type=" + type +
                '}';
    }
}
