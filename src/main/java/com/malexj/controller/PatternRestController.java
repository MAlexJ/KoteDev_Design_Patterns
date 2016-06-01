package com.malexj.controller;

import com.malexj.model.dto.PatternAllDTO;
import com.malexj.model.enums.PatternTag;
import com.malexj.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PatternRestController {

    @Autowired
    private PatternService patternService;


    @RequestMapping(path = "/creationPatterns", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PatternAllDTO> creation_pattern_get() {
        return patternService.findAllDTO(PatternTag.CREATIONAL);
    }

    @RequestMapping(path = "/behavioralPatterns", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PatternAllDTO> behavioral_pattern_get() {
        return patternService.findAllDTO(PatternTag.BEHAVIORAL);
    }

    @RequestMapping(path = "/structuralPatterns", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PatternAllDTO> structural_pattern_get() {
        return patternService.findAllDTO(PatternTag.STRUCTURAL);
    }
}
