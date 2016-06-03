package com.malexj.model.dto;


import com.malexj.model.dto.base.BaseDTO;
import com.malexj.model.entity.ImageEntity;
import com.malexj.model.enums.PatternTag;

public class PatternAllDTO extends BaseDTO {
    private Long id;
    private String title;
    private PatternTag tag;
    private String text;
    private ImageEntity image;

    public PatternAllDTO() {
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
        PatternAllDTO that = (PatternAllDTO) o;
        return id != null ? id.equals(that.id) : that.id == null
                && (title != null ? title.equals(that.title) : that.title == null
                && tag == that.tag && (text != null ? text.equals(that.text) : that.text == null
                && (image != null ? image.equals(that.image) : that.image == null)));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PatternAllDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag=" + tag +
                ", text='" + text + '\'' +
                ", image=" + image +
                '}';
    }
}
