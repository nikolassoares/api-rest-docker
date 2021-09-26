package com.enquete.apirest.repository;

import com.enquete.apirest.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
    Poll findById(long id);
}
