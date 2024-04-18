package ru.gb.homework20240416.controller;

import ru.gb.homework20240416.domain.Characters;
import ru.gb.homework20240416.service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControllerAPI {

    private final ServiceApi serviceApi;

    @GetMapping("/")
    public ResponseEntity<Characters> getCharacters()
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }
}
