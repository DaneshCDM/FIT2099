package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Resettable;
import game.Status;
import game.Utils;
import game.currency.CoinWallet;
import game.magicalitems.Key;

import java.util.ArrayList;
import java.util.List;

import static game.Monologue.getBowserSentences;

public class Bowser extends Enemies implements Resettable {

    Location storeLocation;
    IntrinsicWeapon intrinsicWeapon;

    private int turnCounter = 0;
    List<String> bowserMonologue = new ArrayList<>(List.of(getBowserSentences()));

    // Bowser's Key
    public static Key bowserKey = new Key();

    public Bowser(Location currentLocation) {
        super("Bowser", 'B', 5);
        this.addCapability(Status.FIRE);
        this.storeLocation = currentLocation;
        registerInstance();

        // Bowser hod the Key to save Princess Peach in his Inventory
        this.addItemToInventory(bowserKey);
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

        // Drop the Key onto map when Bowser dies
        if (!this.isConscious()){
            this.removeItemFromInventory(bowserKey);
            map.locationOf(this).addItem(bowserKey);
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
