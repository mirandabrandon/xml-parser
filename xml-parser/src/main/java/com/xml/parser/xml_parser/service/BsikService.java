package com.xml.parser.xml_parser.service;

import com.xml.parser.xml_parser.model.Bsik;
import com.xml.parser.xml_parser.repository.BsikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BsikService {

    @Autowired
    private BsikRepository bsikRepository;

    public Bsik getLinhaBsikById(Long id) {
        Optional<Bsik> bsik = bsikRepository.findById(id);

        return bsik.orElse(null);
    }

    public List<Bsik> getAllBsik() {
        return bsikRepository.findAll();
    }
}
