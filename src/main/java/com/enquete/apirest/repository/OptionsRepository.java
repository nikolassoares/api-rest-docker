package com.enquete.apirest.repository;

import com.enquete.apirest.models.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsRepository extends JpaRepository<Options, Long> {
    Options findById(long id);
}
