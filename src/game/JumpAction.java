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
    Boolean jumpoutcome;
    Ground targetground;

    public JumpAction(Location location,String direction) {
        this.currentlocation=location;
        this.directionintereseted=direction;
        this.jumpoutcome=false;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //find target ground type
        for (int i=0;i<this.currentlocation.getExits().size();i++){
            if (this.currentlocation.getExits().get(i).getName()==this.directionintereseted){
                this.targetground=this.currentlocation.getExits().get(i).getDestination().getGround();
                break;
            }
        }

        //generate random chance
        Random random=new Random();
        this.probability=random.nextDouble();

        char groundchar=this.targetground.getDisplayChar();
        if (groundchar=='#'){ //target is wall
            this.wall(this.probability);
        } else if(groundchar=='+'||groundchar=='t'||groundchar=='T' ){
            this.tree(probability,groundchar);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    public void wall(Double probability){
        //determine if jump action is successful
        if (probability<=0.8){
            this.jumpoutcome=true;
        }
    }

    public void tree(Double probability,char groundchar){
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
