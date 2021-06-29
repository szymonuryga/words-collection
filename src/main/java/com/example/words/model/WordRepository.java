package com.example.words.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "select distinct a.word from Word a", nativeQuery = true)
    List<String> findDistinctByWord();
}
