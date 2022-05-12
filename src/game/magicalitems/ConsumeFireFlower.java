package game.magicalitems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.Status;

public class ConsumeFireFlower extends Action {
    FireFlower fireflower;
    public ConsumeFireFlower(FireFlower fireflower) {
        this.fireflower=fireflower;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Player.pickedup=true;
        Player.counter=3;
        actor.addCapability(Status.FIRE);
        map.locationOf(actor).removeItem(fireflower);
        return "Your "+actor+" consumed a Fire Flower! Somewhat more attack power now.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Consume fire flower";
    }
}
