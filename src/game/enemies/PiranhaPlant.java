package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.Utils;

import java.util.ArrayList;
import java.util.List;

import static game.Monologue.getPiranhaPlantsSentences;
import static game.Monologue.getPrincessPeachSentences;

public class PiranhaPlant extends Enemies{

    IntrinsicWeapon intrinsicWeapon;

    private int turnCounter = 0;
    List<String> piranhaPlantMonologue = new ArrayList<>(List.of(getPiranhaPlantsSentences()));


    public PiranhaPlant() {
        super("PiranhaPlant", 'Y', 5);
        this.addCapability(Status.NONMOVEABLE);
    }

    public IntrinsicWeapon intrinsicWeapon(){
        intrinsicWeapon = new IntrinsicWeapon(100, "CHOMP");
        return intrinsicWeapon;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // FOR SPEAKING - REQ5:
        // Increment Turn Counter
        turnCounter += 1;

        // Piranha Plant speaks every Second (Alternating) turn
        if(turnCounter % 2 == 0){
            System.out.println("Piranha Plant" + ": " + piranhaPlantMonologue.get(Utils.randomIndexTwo()));
        }

        return super.playTurn(actions, lastAction, map, display);
    }
}
