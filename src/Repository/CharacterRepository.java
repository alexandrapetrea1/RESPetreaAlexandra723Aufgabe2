package Repository;

import java.util.ArrayList;
import java.util.List;
import Model.Character;

/**
 * Repository for managing characters in the Game of Thrones trading network.
 */

public class CharacterRepository implements IRepository<Character,Integer> {
    private List<Character> characters = new ArrayList<>();


    /**
     * Adds a new character to the repository.
     *
     * @param character The character to add.
     * @return true if the character was added successfully, false otherwise.
     */
    @Override
    public void add(Character character) {
        characters.add(character);
    }


    /**
     * Removes a character from the repository.
     *
     * @param character The character to remove.
     * @return true if the character was removed, false otherwise.
     */
    @Override
    public void remove(Character character) {
        characters.remove(character);
    }

    /**
     * Returns a list of all characters in the repository.
     * A copy of the list is returned to prevent external modifications.
     *
     * @return List of characters.
     */
    @Override
    public List<Character> getAll() {
        return characters;
    }


    /**
     * Finds a character by ID.
     *
     * @param id The ID of the character.
     * @return The character if found, otherwise null.
     */
    @Override
    public Character findByIdentifier(Integer id) {
        return characters.stream()
                .filter(p -> p.getCharacterId() == id)
                .findFirst()
                .orElse(null);
    }


    /**
     * Updates an existing character in the repository.
     * If the character is found, its name and origin place are updated.
     *
     * @param character The character with updated values.
     */
    @Override
    public void update(Character character) {
        Character existing = findByIdentifier(character.getCharacterId());
        if (existing != null) {
            existing.setName(character.getName());
            existing.setOriginPlace(character.getOriginPlace());
        }
    }
}
