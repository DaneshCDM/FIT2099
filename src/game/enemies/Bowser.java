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
import game.Utils;
import game.behaviours.Behaviour;

import java.util.ArrayList;
import java.util.List;

import static game.Monologue.getBowserSentences;
import static game.Monologue.getPrincessPeachSentences;

public class Bowser extends Enemies implements Resettable {

    Location storeLocation;
    IntrinsicWeapon intrinsicWeapon;

    private int turnCounter = 0;
    List<String> bowserMonologue = new ArrayList<>(List.of(getBowserSentences()));

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
//                map.moveActor(this, storeLocation);
            }
        }

        // FOR SPEAKING - REQ5:
        // Increment Turn Counter
        turnCounter += 1;

        // Bowser speaks every Second (Alternating) turn
        if(turnCounter % 2 == 0){
            System.out.println("Bowser" + ": " + bowserMonologue.get(Utils.randomIndexFull()));
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
