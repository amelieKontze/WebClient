package de.neuefische.webclient.controller;


import de.neuefische.webclient.model.RMCharacters;
import de.neuefische.webclient.model.RMResponse;
import de.neuefische.webclient.service.RickAndMortyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyService RMService;

    @GetMapping("/all_characters")
    public List<RMCharacters> getAllCharacters(){
        return RMService.getAllCharacters();
    }

    @GetMapping("/alive/{status}")
    public List<RMCharacters> getAllAlive(@PathVariable String status){
        return RMService.getByStatus(status);
    }

}
