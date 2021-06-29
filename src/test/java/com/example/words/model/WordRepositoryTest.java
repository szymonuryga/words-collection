package com.example.words.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WordRepositoryTest {

    @Autowired
    private WordRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldFindDistinctByWordWithTheSameWord() {
        int expectedSize = 1;
        Word word = new Word(1L,"random");
        Word word1 = new Word(2L,"random");
        underTest.save(word);
        underTest.save(word1);

        List<String> words = underTest.findDistinctByWord();
        int size = words.size();

        Assertions.assertEquals(expectedSize, size);
    }

    @Test
    void itShouldFindDistinctByWordWithDifferentWords() {
        int expectedSize = 1;
        Word word = new Word(1L,"random");
        Word word1 = new Word(2L,"word");
        underTest.save(word);
        underTest.save(word1);

        List<String> words = underTest.findDistinctByWord();
        int size = words.size();

        Assertions.assertNotEquals(expectedSize, size);
    }
}