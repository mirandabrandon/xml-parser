package com.xml.parser.xml_parser.repository;

import com.xml.parser.xml_parser.model.Bsak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BsakRepository extends JpaRepository<Bsak, Long> {
}
