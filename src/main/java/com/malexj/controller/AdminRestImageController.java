package com.malexj.controller;

import com.malexj.exception.ImageNotAvailableException;
import com.malexj.model.dto.ImageAllDTO;
import com.malexj.model.dto.ImageIdAndNameDTO;
import com.malexj.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestImageController {

    @Autowired
    private ImageService imageService;

    //GET LIST
    @RequestMapping(path = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImageIdAndNameDTO> admin_pages_update() {
        return imageService.findDTO();
    }

    //GET LIST ONE
    @RequestMapping(path = "/viewImage/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ImageAllDTO admin_image_view(@PathVariable Long id) {
        if (id > 0) {
            return imageService.findOneDTO(id);
        }
        return null;
    }

    //CREATE
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/createImage", method = RequestMethod.POST)
    public void admin_image_create(@RequestParam("file") CommonsMultipartFile file) {
        if (!file.isEmpty()) {
            ImageAllDTO image = new ImageAllDTO();
            image.setAvailable(true);
            image.setName(file.getOriginalFilename());
            image.setImg(file.getBytes());
            imageService.saveDTO(image);
        }
    }

    //DELETE
    @RequestMapping(path = "/deleteImage/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> admin_image_delete(@PathVariable Long id) {
        if (id > 0) {
            try {
                imageService.delete(id);
            } catch (ImageNotAvailableException e) {
                return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
            }
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
    }

}
