package game.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Ground.Teleportation;
import game.SpeakAction;
import game.TradeAction;
import game.magicalitems.*;

public abstract class Fountain extends Ground {

    Bottle bottle = Bottle.bottle;

    public static Fountain fountain;

    public Fountain(char displayChar) {
        super(displayChar);
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList newActions = new ActionList();
        if (location.containsAnActor() == true) {
            newActions.add(new RefillBottle(this));
        }
        return newActions;
    }
}
