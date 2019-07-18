package pl.jn.demo.service;

import org.springframework.stereotype.Service;
import pl.jn.demo.model.Phrases;
import pl.jn.demo.model.PhrasesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhrasesService {
    private Phrases phrases;

    public List<PhrasesData> getAllPhrases() {
        return phrases.getPhrasesData();
    }

    public void fillData(Phrases phrases) {
        this.phrases = phrases;
    }

//    should better handled. Example some throw exception
    public PhrasesData getPhraseByCharacterId(String characterId) {
        return this.phrases.getPhrasesData().stream().filter(phrasesData -> characterId.equals(phrasesData.getCharacter())).findFirst().orElse(null);
    }

    public void addPhrasesData(PhrasesData phrasesData) {
        if(this.phrases.getPhrasesData()!=null) {
            this.phrases.getPhrasesData().add(phrasesData);
        } else {
            this.phrases.setPhrasesData(new ArrayList<>());
            this.phrases.getPhrasesData().add(phrasesData);
        }
    }

    public PhrasesData updatePhrasesData(PhrasesData phrasesDataToUpdate) {
        String phraseId = phrasesDataToUpdate.getId();
        Optional<PhrasesData> characterData = getPhraseById(phraseId);
        characterData.ifPresent(data -> this.phrases.getPhrasesData().remove(data));
        addPhrasesData(phrasesDataToUpdate);
        return phrasesDataToUpdate;
    }


    public void removePhrasesById(String phraseId){
        Optional<PhrasesData> characterData = getPhraseById(phraseId);
        characterData.ifPresent(data -> this.phrases.getPhrasesData().remove(data));
    }

    private Optional<PhrasesData> getPhraseById(String phrasesId) {
        return this.phrases.getPhrasesData().stream().filter(phrasesData-> phrasesId.equals(phrasesData.getId())).findFirst();
    }

}
