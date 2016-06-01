package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;
import com.malexj.model.entity.ImageEntity;
import com.malexj.model.enums.PatternTag;

public class PatternDTO extends BaseDTO {

    private String title;

    private PatternTag tag;

    private String text;

    private ImageEntity image;

    public PatternDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PatternTag getTag() {
        return tag;
    }

    public void setTag(PatternTag tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatternDTO that = (PatternDTO) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (tag != that.tag) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return image != null ? image.equals(that.image) : that.image == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PatternDTO{" +
                "title='" + title + '\'' +
                ", tag=" + tag +
                ", text='" + text + '\'' +
                ", image=" + image +
                '}';
    }
}
