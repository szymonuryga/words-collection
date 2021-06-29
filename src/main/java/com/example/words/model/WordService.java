package com.example.words.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public List<Word> findAll(){
        return wordRepository.findAll();
    }

    public Optional<Word> findById(Long id){
        return wordRepository.findById(id);
    }

    public void removeWord(Long id){
        wordRepository.deleteById(id);
    }

    public List<String> findAllUnique(){
        return wordRepository.findDistinctByWord();
    }

    public Integer countNumberOfAppearance(String word){
        List<String> words = findAll()
                .stream()
                .map(Word::getWord)
                .collect(Collectors.toList());
        return Collections.frequency(words, word);
    }

    public Word save(Word word){
        return wordRepository.save(word);
    }

}
