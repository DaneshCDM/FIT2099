package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;

public class PiranhaPlant extends Enemies{
    IntrinsicWeapon intrinsicWeapon;

    public PiranhaPlant() {
        super("PiranhaPlant", 'Y', 100);
        this.addCapability(Status.NONMOVEABLE);
    }

    public IntrinsicWeapon intrinsicWeapon(){
        intrinsicWeapon = new IntrinsicWeapon(100, "CHOMP");
        return intrinsicWeapon;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }
}
