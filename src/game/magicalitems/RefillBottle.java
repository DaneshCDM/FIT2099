package game.magicalitems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.fountains.Fountain;

public class RefillBottle extends Action {

    Bottle bottle = Bottle.bottle;
    Fountain fountain;

    public RefillBottle(Fountain fountain) {
        this.fountain = fountain;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Water water = new Water();
        bottle.refillingBottle(water);
        return actor + " has refilled his bottle with " + water;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has refilled his bottle from the " + fountain;
    }
}
