/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.services.formatters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pqkallio
 */
public class BibTeXCharacterMapper implements CharacterMapper {
    private Map<Character, String> mapper;
    
    public BibTeXCharacterMapper() {
        this.mapper = new HashMap<>();
        initMapper();
    }
    
    @Override
    public String getStringMappedFor(char c) {
        if (mapper.containsKey(c)) {
            return mapper.get(c);
        }
        
        return null;
    }

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

    private void insertCharactersToMapper(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            char c = (char)i;
            mapper.put(c, Character.toString(c));
        }
    }
}