package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Resettable;
import game.Status;

import java.util.List;

public class SuperMushroom extends Item implements Resettable {
//    SuperMushroom superMushroom = new SuperMushroom("SuperMushroom", '^', false);
    MagicalItems magicalItems = new MagicalItems(this);
    Actor actor;
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public SuperMushroom(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        addAction(magicalItems);
        this.registerInstance();
    }

    public void addToActorInvertory(Actor actor){
        List<Item> i = actor.getInventory();
        for (int a = 0; a < i.size(); a++){
            if ((i.get(a) instanceof SuperMushroom) == false){
                actor.addItemToInventory(this);
            }
        }
    }

    public void actorUsesItem(Actor actor) {
        actor.hasCapability(Status.TALL);
        actor.increaseMaxHp(50);
        actor.removeItemFromInventory(this);
    }

    @Override
    public void resetInstance() {
        removeCapability(Status.TALL);
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
