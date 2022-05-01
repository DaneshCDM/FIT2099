package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Arrays;
import java.util.List;

import static game.Monologue.S1;

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

        int randomIndex = Utils.randomIndex();
        List<String> monologueSentences = Arrays.asList(Monologue.getMonologueSentences());

        for(int i = 0; i < actor.getInventory().size(); i ++){
            if (actor.getInventory().get(i).toString().equals("Wrench")){
                monologueSentences.remove(S1);
            }
        }

        return (target) + ": " + monologueSentences.get(randomIndex);
    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " speaks to " + target);
    }


}



