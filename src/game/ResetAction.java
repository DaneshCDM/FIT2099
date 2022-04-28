package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ResetAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        return "The game has been reset to baby mode.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game. (removes enemies, player status, reset player health, some trees and all coins on the ground) [can only be done once!] p.s for pussies";
    }
}
