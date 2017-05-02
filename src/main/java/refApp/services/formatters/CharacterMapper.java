
package refApp.services.formatters;


/**
 * A Character mapper interface
 * 
 * @author pqkallio
 */



public interface CharacterMapper {
    /**
     * Get the string mapped for a given character.
     * 
     * @param c the character
     * @return the string mapped for the character
     */
    public String getStringMappedFor(char c);
}
