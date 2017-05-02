/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.services.formatters;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * A helper class to replace characters to BibTeX form, designed to support
 * nordic alphabets.
 * 
 * @author pqkallio
 */
@Service
public class BibTeXCharacterMapper implements CharacterMapper {
    private Map<Character, String> mapper;
    
    /**
     * Create new BibTeXCharacterMapper
     */
    public BibTeXCharacterMapper() {
        this.mapper = new HashMap<>();
        initMapper();
    }
    
    /**
     * Get the string required by the BibTeX form mapped for a given character.
     * 
     * @param c the character
     * @return the string mapped for the character
     */
    @Override
    public String getStringMappedFor(char c) {
        if (mapper.containsKey(c)) {
            return mapper.get(c);
        }
        
        return null;
    }

    /**
     * A helper method to initialize the character map.
     */
    private void initMapper() {
        insertCharactersToMapper(65, 90);
        insertCharactersToMapper(97, 122);
        
        mapper.put('ä', "{\\\"a}");
        mapper.put('ö', "{\\\"o}");
        mapper.put('ü', "{\\\"u}");
        mapper.put('å', "{\\aa}");
        mapper.put('Ä', "{\\\"A}");
        mapper.put('Ö', "{\\\"O}");
        mapper.put('Ü', "{\\\"U}");
        mapper.put('Å', "{\\AA}");
    }

    /**
     * A helper method to map a range of characters.
     * 
     * @param startIndex the index of the first character
     * @param endIndex the index of the last character
     */
    private void insertCharactersToMapper(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            char c = (char)i;
            mapper.put(c, Character.toString(c));
        }
    }
}