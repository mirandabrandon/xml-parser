package com.xml.parser.xml_parser.repository;

import com.xml.parser.xml_parser.model.Bsik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BsikRepository extends JpaRepository<Bsik, Long> {
}
