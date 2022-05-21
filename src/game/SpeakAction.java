package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static game.Monologue.*;

public class SpeakAction extends Action {

    private final Actor target;

    /**
     *
     * @param target the Actor that we want to speak to
     */
    public SpeakAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        int randomIndex = Utils.randomIndexFull();
        boolean flagOneRemoved = true;

        List<String> toadMonologue = new ArrayList<>(List.of(getToadSentences()));

        // Remove 1st Sentence if Player has Wrench
        for(int i = 0; i < actor.getInventory().size(); i ++){
            if (actor.getInventory().get(i).toString().equals("Wrench")){
                toadMonologue.remove(T1);
                randomIndex = Utils.randomIndexThree();
                flagOneRemoved = false;
            }
        }

        // Remove 2nd Sentence if Player has Power Star Effect
        if (actor.hasCapability(Status.INVINCIBLE) && !flagOneRemoved){
            toadMonologue.remove(T2);
            randomIndex = Utils.randomIndexTwo();
        }
        else if(actor.hasCapability(Status.INVINCIBLE)){
            toadMonologue.remove(T2);
            randomIndex = Utils.randomIndexThree();
        }

        return (target) + ": " + toadMonologue.get(randomIndex);
    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " speaks to " + target);
    }


}



