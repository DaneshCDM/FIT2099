package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.magicalitems.*;

public abstract class Fountain extends Ground {

    Bottle bottle = Bottle.bottle;

    public static Fountain fountain;

    /**
     *
     * @param displayChar
     */
    public Fountain(char displayChar) {
        super(displayChar);
        fountain = this;
    }

    /**
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList newActions = new ActionList();
        if (location.containsAnActor() == true) {
            newActions.add(new RefillBottle(this));
        }
        return newActions;
    }

    /**
     *
     * @param drinkWater
     * @return
     */
    public abstract String fountainsEffect(DrinkWater drinkWater);

    public abstract String typeOfWater();
}
