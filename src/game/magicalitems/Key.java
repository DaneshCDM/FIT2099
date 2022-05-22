package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;

public class Key extends Item {

    /**
     * Key Item Attributes
     */
    private static final String NAME = "Key";
    private static final Character DISPLAY_CHARACTER = 'k';
    private static final boolean PORTABLE = true;

    /***
     * Key Item Constructor
     */
    public Key() {
        super(NAME, DISPLAY_CHARACTER, PORTABLE);
    }

}
