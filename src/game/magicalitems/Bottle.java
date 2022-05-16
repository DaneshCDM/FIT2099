package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Status;

import java.util.List;
import java.util.Stack;

public class Bottle extends Item {
    DrinkWater drinkWater;
    Stack<Water> drinkingWater = new Stack<Water>();

    public static Bottle bottle; // instance of Bottle to update the status of refillingBottle

    public Bottle(DrinkWater drinkingWater) {
        super("Bottle", 'b', false);
        bottle = this;
        drinkWater = drinkingWater;
    }

    public boolean isdrinkingWaterEmpty() {
        return drinkingWater.empty();
    }

    public String actorUsesItem() {
        String output = "";
        if (isdrinkingWaterEmpty() == false){
//            output = drinkingWater.pop();
            bottle = this;
        }
        else {
            output = "Heyyyyyy!!!! THE BOTTLE IS EMPTY :-(";
        }
        return output;
    }

    public void refillingBottle (Water water) {
        bottle = this;
        drinkingWater.push(water);
    }

    @Override
    public String toString() {
        return "Bottle" + drinkingWater;
    }
}
