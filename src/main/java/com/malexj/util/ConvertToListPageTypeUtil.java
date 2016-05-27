package com.malexj.util;

import com.malexj.model.enums.PageType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertToListPageTypeUtil {
    private  ArrayList<PageType> result;

    public List<PageType> convert(List<PageType> list){
       this.result = new ArrayList<>(Arrays.asList(PageType.values()));
        for (PageType type : list) {
            if (result.contains(type)) {
                result.remove(type);
            }
        }
        return this.result;
    }
}
