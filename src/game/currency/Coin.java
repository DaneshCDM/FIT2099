package game.currency;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

import java.util.List;

/**
 *  * Coin class manages everything to do with a Coin Object
 *  *
 *  * @author Danesh Mariapan
 */
public class Coin extends Item implements Resettable {

    /**
     * Attributes / Variables of the Coin Class
     */
    private static final String NAME = "Coin";
    private static final Character DISPLAY_CHARACTER = '$';
    private static final boolean PORTABLE = true;
    private int value;
    Location location;

    /**
     * Coin Constructor
     *
     * @param value the currency value that the Coin has
     */
    public Coin(int value) {
        super(NAME, DISPLAY_CHARACTER, PORTABLE);
        this.value = value;
        this.registerInstance();

        Action coinPickUpItemAction = new CoinPickUpItemAction(this);
        addAction(coinPickUpItemAction);
    }

    // Getter for Coin Value
    public int getValue() {
        return value;
    }

    // Setter for Coin Value
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void tick(Location currentLocation) {
        this.location = currentLocation;
    }

    // Returns "Coin ($value)
    @Override
    public String toString() {
        return super.toString() + " " + "(" + this.getDisplayChar() + this.getValue() + ")";
    }

    // Returns the type of Coin ($value)
    public String getCoinType() {
        return this.toString();
    }

    /**
     * Overriding Resettable Class methods
     * To remove Coins from the Map, when Map gets reset
     */
    @Override
    public void resetInstance() {
        this.location.removeItem(this);
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return null;
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

}


