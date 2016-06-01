package com.malexj.model.vo;


import com.malexj.model.enums.PatternTag;

import java.io.Serializable;

public class PatternAllVO implements Serializable{

    private Long id;

    private String title;

    private PatternTag tag;

    private String text;

    private String image;

    public PatternAllVO() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatternAllVO that = (PatternAllVO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (tag != that.tag) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return image != null ? image.equals(that.image) : that.image == null;

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
        return "PatternAllVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag=" + tag +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
