package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class JumpAction extends Action {

    double probability;
    String directionintereseted;
    Location targetlocation;
    Boolean jumpoutcome;
    Ground targetground;
    int x;
    int y;
    int damage;

    public JumpAction(Location location,String direction) {
        this.targetlocation=location;
        this.directionintereseted=direction;
        this.jumpoutcome=false;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //sets the target ground type and x/y coordinates
        this.targetground=targetlocation.getGround();
        x=targetlocation.x();
        y=targetlocation.y();

        //generate random chance
        Random random=new Random();
        this.probability=random.nextDouble();

        //check if player ate super mushroom
        if (actor.hasCapability(Status.TALL)){
            successfuljump(actor,map);
            System.out.println("Your "+actor+" got superpowers");
        } else {
            //check jump target
            char groundchar = this.targetground.getDisplayChar();
            if (groundchar == '#') { //target is wall
                System.out.println("Wall("+x+","+y+")");
                this.wall(this.probability, actor, map);
            } else if (groundchar == '+' || groundchar == 't' || groundchar == 'T') { //target is tree
                System.out.println("Tree("+x+","+y+")");
                this.tree(probability, groundchar, actor, map);
            }
        }
        //////System.out.println("conscious? "+actor.isConscious());]

        //check for successful jump
        if (this.jumpoutcome){
            return "Your "+actor.toString()+" succeeded for the first time in their life and jumped to location ("+x+","+y+")";
        } else{
            return "Your "+actor.toString()+" is the living embodiment of failure and remains at location ("+x+","+y+") after taking "+damage+" damage.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Jump to climbable object "+this.directionintereseted;
    }

    public void wall(Double probability, Actor actor,GameMap map){
        //determine if jump action is successful
        if (probability<=0.8){ //successful jump
            successfuljump(actor,map);
        } else { //unsuccessful
            uncessfuljump(actor,20);
        }
    }

    public void tree(Double probability,char groundchar, Actor actor,GameMap map){
        //directs to corresponding tree target
        if (groundchar=='+'){
            sprout(probability,actor,map);
        } else if (groundchar=='t'){
            sapling(probability,actor,map);
        } else if (groundchar=='T'){
            mature(probability,actor,map);
        }
    }

    public void sprout(Double probability,Actor actor,GameMap map){
        if (probability<0.9){ //success
            successfuljump(actor,map);
        } else{ //actor takes damage
            uncessfuljump(actor,10);
        }
    }

    public void sapling(Double probability,Actor actor,GameMap map){
        if (probability<0.8){ //success
            successfuljump(actor,map);
        } else{//actor takes damage
            uncessfuljump(actor,20);
        }
    }

    public void mature(Double probability,Actor actor,GameMap map){
        if (probability<0.7){ //success
            successfuljump(actor,map);
        } else{//actor takes damage
            uncessfuljump(actor,30);
        }
    }

    public void successfuljump(Actor actor,GameMap map){
        //changes jumpoutcome to true and moves actor to target location
        this.jumpoutcome=true;
        map.moveActor(actor,this.targetlocation);
    }

    public void uncessfuljump(Actor actor,int value){
        //deals damage to actor for failing jump
        this.damage=value;
        actor.hurt(value);
    }
}
