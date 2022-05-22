package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magicalitems.Key;

import static game.enemies.Bowser.bowserKey;

public class SavePrincessAction extends Action {

    private final Actor target;

    /**
     * Constructor for the Action
     * @param target the Actor that we want to interact with (Princess Peach)
     */
    public SavePrincessAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        // Check if Player/Mario has the Key to save Princess Peach
        if (actor.getInventory().contains(bowserKey)){
            return ("""
                    *******************************************
                    ***       CONGRATULATIONS PLAYER!       ***
                    *******************************************
                    ***     You saved Princess Peach :D     ***
                    *******************************************""");
        }
        else{
            return (target) + ": " + "Mario you need to Kill Bowser and take his Key to save me! ;( ";
        }

    }

    @Override
    public String menuDescription(Actor actor) {
        return "Save Princess Peach";
    }

}
