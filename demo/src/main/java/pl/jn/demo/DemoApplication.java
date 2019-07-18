package pl.jn.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jn.demo.model.Characters;
import pl.jn.demo.model.Phrases;
import pl.jn.demo.service.CharactersService;
import pl.jn.demo.service.PhrasesService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(CharactersService charactersService, PhrasesService phrasesService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            InputStream charactersInputStream = new FileInputStream("./data/characters.json");
            InputStream phraseInputStream = new FileInputStream("./data/phrases.json");
            try {
                Characters character = mapper.readValue(charactersInputStream, Characters.class);
                Phrases phrases = mapper.readValue(phraseInputStream, Phrases.class);
                charactersService.fillData(character);
                phrasesService.fillData(phrases);
            } catch (IOException e) {
                log.error("Unable to read Characters: ", e);
            }
        };
    }
}
