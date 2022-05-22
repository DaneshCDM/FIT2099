package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.SavePrincessAction;
import game.Utils;

import java.util.ArrayList;
import java.util.List;

import static game.Monologue.getPrincessPeachSentences;

public class PrincessPeach extends Actor {

    /**
     * Princess Peach Attributes
     */
    private static final String NAME = "Princess Peach";
    private static final Character DISPLAY_CHARACTER = 'P';
    private static final int HIT_POINTS = 1;

    private int turnCounter = 0;
    List<String> princessPeachMonologue = new ArrayList<>(List.of(getPrincessPeachSentences()));

    /**
     * Constructor for Princess Peach
     */
    public PrincessPeach() {
        super(NAME, DISPLAY_CHARACTER, HIT_POINTS);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // FOR SPEAKING - REQ5:
        // Increment Turn Counter
        turnCounter += 1;

        // Princess Peach speaks every Second (Alternating) turn
        if(turnCounter % 2 == 0){
            System.out.println(NAME + ": " + princessPeachMonologue.get(Utils.randomIndexThree()));
        }

        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        // Add SavePrincessAction for End Game
        return new ActionList(new SavePrincessAction(this));
    }

}
