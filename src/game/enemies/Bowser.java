package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Resettable;
import game.Status;
import game.behaviours.Behaviour;

public class Bowser extends Enemies implements Resettable {

    Location storeLocation;
    IntrinsicWeapon intrinsicWeapon;

    public Bowser(Location currentLocation) {
        super("Bowser", 'B', 500);
        this.addCapability(Status.FIRE);
        this.storeLocation = currentLocation;
        registerInstance();
    }

    public IntrinsicWeapon intrinsicWeapon(){
        intrinsicWeapon = new IntrinsicWeapon(80, "PUNCH");
        return intrinsicWeapon;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (this.hasCapability(Status.BOWSER)) {
            if (storeLocation.containsAnActor() == false){
                this.removeCapability(Status.BOWSER);
                map.moveActor(this, storeLocation);
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    public String toString() {
        return "Bowser";
    }

    @Override
    public void resetInstance() {
        storeLocation.map().removeActor(this);
        storeLocation.map().at(15, 8).addActor(new Bowser(storeLocation.map().at(15, 8)));
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
