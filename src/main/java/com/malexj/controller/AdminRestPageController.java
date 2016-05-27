package com.malexj.controller;

import com.malexj.model.dto.PageAllDTO;
import com.malexj.model.dto.PageDTO;
import com.malexj.model.dto.PageIdAndTypeDTO;
import com.malexj.model.enums.PageType;
import com.malexj.service.impl.PageServiceImpl;
import com.malexj.util.ConvertToListPageTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestPageController {

    @Autowired
    private PageServiceImpl pageService;

    // CREATE
    @RequestMapping(path = "/pageGetType", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PageType> admin_page_type() {
        return new ConvertToListPageTypeUtil().convert(pageService.findType());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/createPage", method = RequestMethod.POST)
    public void admin_page_create(@RequestBody PageDTO page) {
        pageService.saveDTO(page);
    }

    //DELETE
    @RequestMapping(path = "/deletePages", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PageIdAndTypeDTO> admin_pages_delete() {
        return pageService.findAllIdAndTypeDTO();
    }

    @RequestMapping(path = "/deletePage/{id}", method = RequestMethod.DELETE)
    public void admin_page_delete(@PathVariable Long id) {
        if (id > 0) {
            pageService.delete(id);
        }
    }

    //UPDATE
    @RequestMapping(path = "/updatePages", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PageIdAndTypeDTO> admin_pages_update() {
        return pageService.findAllIdAndTypeDTO();
    }

    @RequestMapping(path = "/updateGetPage/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PageAllDTO admin_page_update_get(@PathVariable Long id) {
        PageAllDTO page = null;
        if (id > 0) {
            page = pageService.findDTO(id);
        }
        return page;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/updatePage", method = RequestMethod.POST)
    public void admin_page_update(@RequestBody PageAllDTO page) {
        pageService.updateDTO(page);
    }

}
