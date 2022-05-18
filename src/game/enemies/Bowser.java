package game.enemies;

public class Bowser extends Enemies{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Bowser(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
