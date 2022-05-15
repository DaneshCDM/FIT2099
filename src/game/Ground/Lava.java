package game.Ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

public class Lava extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Lava() {
        super('L');
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) {
            location.getActor().hurt(15);
        }
        super.tick(location);
        }

        @Override
    public boolean canActorEnter(Actor actor) {
        boolean retval = false;
        if (actor.hasCapability(Status.LAVA)){
            retval = true;
        }
        return retval;
    }
}
