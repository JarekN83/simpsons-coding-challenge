package pl.jn.demo.service;

import org.springframework.stereotype.Service;
import pl.jn.demo.model.Characters;
import pl.jn.demo.model.CharactersData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharactersService {

    private Characters characters;

    public List<CharactersData> getAllCharacters() {
        return characters.getCharactersData();
    }

    public void fillData(Characters characters) {
        this.characters = characters;
    }

    public void addCharacterData(CharactersData charactersData) {
        if (this.characters.getCharactersData() != null) {
            this.characters.getCharactersData().add(charactersData);
        } else {
            this.characters.setCharactersData(new ArrayList<>());
            this.characters.getCharactersData().add(charactersData);
        }
    }

    //    maybe here should we remove connected phrases?
    public void removeCharactersData(String characterId) {
        Optional<CharactersData> characterData = getCharacterById(characterId);
        characterData.ifPresent(data -> this.characters.getCharactersData().remove(data));
    }

    //    in this solution record has been removed and added
    public CharactersData updateCharacterData(CharactersData charactersDataToUpdate) {
        String characterId = charactersDataToUpdate.getId();
        Optional<CharactersData> characterData = getCharacterById(characterId);
        characterData.ifPresent(data -> this.characters.getCharactersData().remove(data));
        addCharacterData(charactersDataToUpdate);
        return charactersDataToUpdate;
    }

    private Optional<CharactersData> getCharacterById(String characterId) {
        return this.characters.getCharactersData().stream().filter(charactersData -> characterId.equals(charactersData.getId())).findFirst();
    }
}
