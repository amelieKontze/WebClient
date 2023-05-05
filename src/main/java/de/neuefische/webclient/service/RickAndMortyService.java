package de.neuefische.webclient.service;

import de.neuefische.webclient.model.RMCharacters;
import de.neuefische.webclient.model.RMResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RickAndMortyService {


   WebClient webClient = WebClient.create("https://rickandmortyapi.com/");

   public List<RMCharacters> getAllCharacters(){
       RMResponse response =
               Objects.requireNonNull(webClient.get())
               .uri("api/character")
               .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
               .retrieve()
               .toEntity(RMResponse.class)
               .block()
               .getBody();
       return response.getResults();
   }

    public List<RMCharacters> getByStatus(String status){
        RMResponse response =
                Objects.requireNonNull(webClient.get())
                        .uri("api/character?name=rick&status=" + status)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RMResponse.class)
                        .block()
                        .getBody();
        return response.getResults();
    }


}//end class
