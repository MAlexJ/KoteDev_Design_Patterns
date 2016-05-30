package com.malexj.controller;

import com.malexj.controller.base.AbstractController;
import com.malexj.model.dto.ImageIdAndNameDTO;
import com.malexj.model.dto.PageDTO;
import com.malexj.service.ImageService;
import com.malexj.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestPatternController extends AbstractController {

    @Autowired
    private ImageService imageService;

//    @Autowired
//    private PatternService patternService;

    //GET LIST
    @RequestMapping(path = "/imagesPattern", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImageIdAndNameDTO> admin_images_get() {
        return imageService.findByIsAvailableDTO(true);
    }

    // CREATE
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/createPattern", method = RequestMethod.POST)
    public void admin_pattern_create(@RequestParam("id_image") Long id_image,
                                     @RequestParam("tag") String tag,
                                     @RequestParam("title") String title,
                                     @RequestParam("text") String text) {
        if (id_image > 0 && validateParam(tag, title, text)) {
            System.err.println("id_image " + id_image);
            System.err.println("tag " + tag);
            System.err.println("title " + title);
            System.err.println("text " + text);
        }
    }

}
