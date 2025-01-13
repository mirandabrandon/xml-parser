package com.xml.parser.xml_parser.repository;

import com.xml.parser.xml_parser.model.Bsid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BsidRepository extends JpaRepository<Bsid, Long> {
}
