package com.malexj.controller;

import com.malexj.model.dto.ImageIdAndNameDTO;
import com.malexj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestPatternController {

    @Autowired
    private ImageService imageService;

    //GET LIST
    @RequestMapping(path = "/imagesPattern", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImageIdAndNameDTO> admin_images_get() {
        return imageService.findByIsAvailableDTO(true);
    }
}
