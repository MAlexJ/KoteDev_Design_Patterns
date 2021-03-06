package com.malexj.model.dto;

import com.malexj.model.dto.base.BaseDTO;

import java.util.Arrays;

public class ImageAllDTO extends BaseDTO {

    private String name;

    private byte[] img;

    private boolean isAvailable;

    public ImageAllDTO() {
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
        ImageAllDTO that = (ImageAllDTO) o;
        return isAvailable == that.isAvailable
                && (name != null ? name.equals(that.name) : that.name == null
                && Arrays.equals(img, that.img));

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }
}
