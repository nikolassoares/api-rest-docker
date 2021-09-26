package com.enquete.apirest.repository;

import com.enquete.apirest.models.Poll;
import com.enquete.apirest.models.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long> {
    Stats findStatsByPoll(Poll poll);
}
