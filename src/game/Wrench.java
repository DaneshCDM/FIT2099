package game;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem {

    public static final String NAME = "Wrench";
    private static final Character DISPLAY_CHARACTER = 'w';
    private static final int DAMAGE = 50;
    private static final String VERB = "POW";
    private static final int HITRATE = 80;

    /**
     * Constructor for Wrench Weapon Item
     */
    public Wrench() {
        super(NAME, DISPLAY_CHARACTER, DAMAGE, VERB, HITRATE);
    }




}
