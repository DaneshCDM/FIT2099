package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;

public class Koopa extends Enemies {
    IntrinsicWeapon intrinsicWeapon;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Koopa(String name, char displayChar, int hitPoints) {
        super("Koopa", 'K', 100);
    }

    public IntrinsicWeapon intrinsicWeapon(){
        intrinsicWeapon = new IntrinsicWeapon(30, "PUNCH");
        return intrinsicWeapon;
    }

    @Override
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
//        ADD CODE FOR LAST POINT IN IMPLEMENTATION EXPECTATIONS (NOT CLEAR)
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (isConscious() == false) {
            if (hasCapability(Status.DORMANT) == false){
                addCapability(Status.DORMANT);
                setDisplayChar('D');
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }
}
