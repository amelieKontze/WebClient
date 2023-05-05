package de.neuefische.webclient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RMCharacters {

    private int id;
    private String name;
    private String status;
    private String species;


}
