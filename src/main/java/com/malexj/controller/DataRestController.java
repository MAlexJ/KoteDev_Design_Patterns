package com.malexj.controller;

import com.malexj.model.dto.PageAllDTO;
import com.malexj.model.enums.PageType;
import com.malexj.service.impl.PageServiceImpl;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class DataRestController {

    @Autowired
    private PageServiceImpl pageService;

    @RequestMapping(path = "/intro", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageAllDTO intro_get() {
        PageAllDTO page = null;
        try {
            page = pageService.findPageDTO(PageType.INTRO);
        } catch (MappingException e) {
            return new PageAllDTO(0L, "Empty", PageType.INTRO);
        }
        return page;
    }

    @RequestMapping(path = "/behavioral", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageAllDTO behavioral_get() {
        PageAllDTO page = null;
        try {
            page = pageService.findPageDTO(PageType.BEHAVIORAL);
        } catch (MappingException e) {
            return new PageAllDTO(0L, "Empty", PageType.BEHAVIORAL);
        }
        return page;
    }

    @RequestMapping(path = "/creational", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageAllDTO creational_get() {
        PageAllDTO page = null;
        try {
            page = pageService.findPageDTO(PageType.CREATIONAL);
        } catch (MappingException e) {
            return new PageAllDTO(0L, "Empty", PageType.CREATIONAL);
        }
        return page;
    }

    @RequestMapping(path = "/structural", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageAllDTO structural_get() {
        PageAllDTO page = null;
        try {
            page = pageService.findPageDTO(PageType.STRUCTURAL);
        } catch (MappingException e) {
            return new PageAllDTO(0L, "Empty", PageType.STRUCTURAL);
        }
        return page;
    }

}
