package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction){
		ActionList actions = new ActionList();
		if (actor.getDisplayChar()=='m') {//check if actor is mario player
			if (location.containsAnActor()==false){//check that location doesnt have another acotr
				actions.add(new JumpAction(location, direction));
			}
		}
		return actions;
	}
}
