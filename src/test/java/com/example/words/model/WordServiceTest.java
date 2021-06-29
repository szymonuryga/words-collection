package com.example.words.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WordServiceTest {

    @Mock
    private WordRepository wordRepository;
    private WordService underTest;

    @BeforeEach
    void setUp() {
        underTest = new WordService(wordRepository);
    }

    @Test
    void canGetAllWords() {
        underTest.findAll();

        verify(wordRepository).findAll();
    }

    @Test
    void findAllUnique() {
        underTest.findAllUnique();

        verify(wordRepository).findDistinctByWord();
    }

}