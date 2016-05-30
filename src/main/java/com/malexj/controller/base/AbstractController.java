package com.malexj.controller.base;


public abstract class AbstractController {

    protected boolean validateParam(String... srt) {
        for (String item : srt) {
            if (item.equals("")) {
                return false;
            }
        }
        return true;
    }
}
