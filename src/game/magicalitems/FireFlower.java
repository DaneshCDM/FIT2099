package game.magicalitems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.actors.Player;

public class FireFlower extends Item{
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FireFlower(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        System.out.println(Player.optionshown);
        Action fireFlowerAction = new ConsumeFireFlower(this);
        addAction(fireFlowerAction);
    }

//    @Override
//    public void tick(Location lcoation, Actor actor){
//        if (Player.pickedup){
//            lcoation.removeItem(this);
//            Player.pickedup=false;
//        }
//    }
}
