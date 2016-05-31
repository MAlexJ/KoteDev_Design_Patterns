package com.malexj.controller;

import com.malexj.controller.base.AbstractController;
import com.malexj.model.dto.*;
import com.malexj.model.entity.ImageEntity;
import com.malexj.model.enums.PatternTag;
import com.malexj.service.ImageService;
import com.malexj.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestPatternController extends AbstractController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private PatternService patternService;

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
    public ResponseEntity<?> admin_pattern_create(@RequestParam("id_image") Long id_image,
                                                  @RequestParam("tag") PatternTag tag,
                                                  @RequestParam("title") String title,
                                                  @RequestParam("text") String text) {
        if (id_image > 0 && validateParam(title, text)) {
            ImageEntity image = imageService.findOne(id_image);
            image.setAvailable(false);
            PatternAllDTO pattern = new PatternAllDTO();
            pattern.setTag(tag);
            pattern.setTitle(title);
            pattern.setText(text);
            pattern.setImage(imageService.save(image));
            patternService.saveDTO(pattern);
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
    }

    //GET list Patter where tag -> CREATIONAL, STRUCTURAL, BEHAVIORAL
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/getPatterns/{tag}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PatternIdAndTitleDTO> admin_patterns_get(@PathVariable PatternTag tag) {
        List<PatternIdAndTitleDTO> patterns = null;
        if (validateNotNull(tag)) {
            patterns = patternService.findAllDTO(tag);
        }
        return patterns;
    }

    //DELETE
    @RequestMapping(path = "/deletePattern/{id}", method = RequestMethod.DELETE)
    public void admin_page_delete(@PathVariable Long id) {
        if (id > 0) {
            ImageEntity image = patternService.findOne(id).getImage();
            image.setAvailable(true);
            imageService.update(image);
            patternService.delete(id);
        }
    }


}
