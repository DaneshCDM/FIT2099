package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.magicalitems.SuperMushroom;

public class FlyingKoopa extends Enemies{

    public FlyingKoopa() {
        super("Flying Koopa", 'F', 150);
        this.addCapability(Status.FLYINGKOOPA);
    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //check for fire on the ground
        FloorOnFire(this,map);

        if (isConscious() == false) {
            if (hasCapability(Status.DORMANT) == false){
                addCapability(Status.DORMANT);
                setDisplayChar('D');
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions;
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
//        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
//            actions.add(new AttackAction(this,direction));
//        }
        if (hasCapability(Status.DORMANT) == false) {
            actions = super.allowableActions(otherActor, direction, map);
        }
        else {
            actions = new ActionList();
        }
        if (this.hasCapability(Status.DORMANT)){
            if (otherActor.hasCapability(Status.HASWRENCH)) {
                location.addItem(new SuperMushroom());
            }
        }
        return actions;
    }
}
