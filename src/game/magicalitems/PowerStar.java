package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

import java.util.List;

public class PowerStar extends Item {
    PowerStar powerStar = new PowerStar("PowerStar", '*', false);
    MagicalItems magicalItems = new MagicalItems(powerStar);
    int invincible_effect_lasts = 10;
    int fadingDuration = 10;
    int flag = 0;
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public PowerStar(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }
    public void actorUsesItem(Actor actor) {
        actor.hasCapability(Status.TALL);
        actor.heal(200);
        List<Item> i = actor.getInventory();
        for (int a = 0; a < i.size(); a++){
            if ((i.get(a) instanceof PowerStar) == false){
                actor.addItemToInventory(powerStar);
            }
        }
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (flag == 1) {
            actor.addCapability(Status.INVINCIBLE);
            invincible_effect_lasts -= 1;
            invincible_effect_lasts(actor);
        }
        else if (flag == 0){
            if (actor.hasCapability(Status.INVINCIBLE)){
                actor.removeCapability(Status.INVINCIBLE);
            }
        }
    }
    public void invincible_effect_lasts(Actor actor){
        if (invincible_effect_lasts <= 0){
            actor.removeItemFromInventory(powerStar);
        }
    }

    @Override
    public void tick(Location currentLocation) {
        powerStar.hasCapability(Status.FADINGDURATION);
        fadingDuration -= 1;
        if (fadingDuration == 0){
            currentLocation.removeItem(powerStar);
        }
    }
}
