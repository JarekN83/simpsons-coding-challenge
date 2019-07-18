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
import pl.jn.demo.service.CharactersService;
import pl.jn.demo.model.CharactersData;

import java.util.List;

@RestController
@RequestMapping("characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharactersService charactersService;

    @GetMapping
    public List<CharactersData> getAllCharacters() {
        return charactersService.getAllCharacters();
    }

    @PostMapping("/add")
    public void addCharacterData(@RequestParam CharactersData charactersData) {
        charactersService.addCharacterData(charactersData);

    }

    @PutMapping("/update")
    public CharactersData updateCharacterData(@RequestParam CharactersData charactersData) {
        return charactersService.updateCharacterData(charactersData);
    }

    @DeleteMapping("/remove/{characterId}")
    public void removeCharacterData(@PathVariable String characterId) {
        charactersService.removeCharactersData(characterId);
    }
}
