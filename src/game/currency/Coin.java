package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

/**
 *  * Coin class manages everything to do with a Coin Object
 *  *
 *  * @author Danesh Mariapan
 */
public class Coin extends Item{

    /**
     * Attributes / Variables of the Coin Class
     */
    private static final String NAME = "Coin";
    private static final Character DISPLAY_CHARACTER = '$';
    private static final boolean PORTABLE = true;
    private int value;

    /**
     * Coin Constructor
     * @param value the currency value that the Coin has
     */
    public Coin(int value){
        super(NAME, DISPLAY_CHARACTER, PORTABLE);
        this.value = value;
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
    public void tick(Location currentLocation, Actor actor) {
        this.tick(currentLocation);
    }

    // Returns "Coin ($value)
    @Override
    public String toString() {
        return super.toString() + " " + "(" + this.getDisplayChar() + this.getValue() + ")";
    }

    // Returns the type of Coin ($value)
    public String getCoinType(){
        return this.toString();
    }


//    @Override
//    public void resetInstance(Location location) {
//        location.removeItem(this);
//    }
//
//    @Override
//    public void registerInstance() {
//        Resettable.super.registerInstance();
//    }
}
