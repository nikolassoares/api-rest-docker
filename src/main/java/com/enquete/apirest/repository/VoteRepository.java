package com.enquete.apirest.repository;

import com.enquete.apirest.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Long>{
    @Query("SELECT v FROM Vote v WHERE v.option_id = ?1 ")
    Vote filterFromOption(long option);
}
