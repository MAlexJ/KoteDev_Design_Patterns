package com.malexj.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malexj.model.entity.base.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Lob
    @Column(name = "img", nullable = false)
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] img;

    @OneToOne(mappedBy = "image")
    @JsonIgnore
    private PatternEntity pattern;

    @Column(name = "available", nullable = false)
    private boolean isAvailable;

    public ImageEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public PatternEntity getPattern() {
        return pattern;
    }

    public void setPattern(PatternEntity pattern) {
        this.pattern = pattern;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEntity that = (ImageEntity) o;
        return isAvailable == that.isAvailable
                && (name != null ? name.equals(that.name) : that.name == null
                && Arrays.equals(img, that.img)
                && (pattern != null ? pattern.equals(that.pattern) : that.pattern == null));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (pattern != null ? 31 : 0);
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }
}
