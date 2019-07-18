package pl.jn.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jn.demo.service.PhrasesService;
import pl.jn.demo.model.PhrasesData;

import java.util.List;

@RestController
@RequestMapping("phrase")
@RequiredArgsConstructor
public class PhraseController {
    private final PhrasesService phrasesService;

    @GetMapping
    public List<PhrasesData> getAllPhrases() {
        return phrasesService.getAllPhrases();
    }

    @PostMapping("/add")
    public void addCharacterData(@RequestParam PhrasesData charactersData) {
        phrasesService.addPhrasesData(charactersData);

    }

    @PutMapping("/update")
    public PhrasesData updateCharacterData(@RequestParam PhrasesData charactersData) {
        return phrasesService.updatePhrasesData(charactersData);
    }

    @DeleteMapping("/remove/{phraseId}")
    public void removeCharacterData(@PathVariable String phraseId) {
        phrasesService.removePhrasesById(phraseId);
    }
}
