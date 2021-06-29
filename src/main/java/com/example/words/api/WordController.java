package com.example.words.api;

import com.example.words.model.Word;
import com.example.words.model.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WordController {
    private final WordService wordService;

    @GetMapping
    public List<Word> findAll(){return wordService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Word> findById(@PathVariable Long id){
        return wordService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/unique")
    public List<String> findAllUnique(){
        return wordService.findAllUnique();
    }

    @GetMapping("/count/{word}")
    public Integer getFrequency(@PathVariable String word){
        return wordService.countNumberOfAppearance(word);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Word createWord(@RequestBody Word word){
       return wordService.save(word);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable Long id ){ wordService.removeWord(id);}



}
