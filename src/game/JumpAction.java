package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class JumpAction extends Action {

    double probability;
    Location currentlocation;
    String directionintereseted;
    Location targetlocation;
    Boolean jumpoutcome;
    Ground targetground;
    GameMap map;

    public JumpAction(Location location,String direction) {
        this.currentlocation=location;
        this.directionintereseted=direction;
        this.jumpoutcome=false;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //find target ground type
        for (int i=0;i<this.currentlocation.getExits().size();i++){ //find target location class && target ground class
            if (this.currentlocation.getExits().get(i).getName()==this.directionintereseted){
                this.targetlocation=this.currentlocation.getExits().get(i).getDestination();
                this.targetground=this.currentlocation.getExits().get(i).getDestination().getGround();
                break;
            }
        }

        //generate random chance
        Random random=new Random();
        this.probability=random.nextDouble();

        //check if player ate super mushroom
        if (actor.hasCapability(Status.TALL)){
            map.moveActor(actor,this.targetlocation);
        }

        //check jump target
        char groundchar=this.targetground.getDisplayChar();
        if (groundchar=='#'){ //target is wall
            this.wall(this.probability,actor);
        } else if(groundchar=='+'||groundchar=='t'||groundchar=='T' ){ //target is tree
            this.tree(probability,groundchar,actor);
        }

        //check for successful jump
        if (this.jumpoutcome==true){
            return "Jump successful";
        } else{
            return "Jump unsuccessful, character took damage because of it's incompetence.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    public void wall(Double probability, Actor actor){
        //determine if jump action is successful
        if (probability<=0.8){ //successful jump
            this.jumpoutcome=true;

        } else { //unsuccessful
            actor.hurt(20);
        }
    }

    public void tree(Double probability,char groundchar, Actor actor){
        //determine if jump action is successful
        if (groundchar=='+'){
            if (probability<0.9){ //success

            }
            //actor takes damage
        } else if (groundchar=='t'){

        } else if (groundchar=='T'){

        }
    }


}
