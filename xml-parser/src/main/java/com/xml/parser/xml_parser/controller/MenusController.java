package com.xml.parser.xml_parser.controller;

import com.xml.parser.xml_parser.model.Bsik;
import com.xml.parser.xml_parser.service.BsikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    private BsikService bsikService;
}
