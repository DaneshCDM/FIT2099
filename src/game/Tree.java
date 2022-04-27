package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Goomba;
import game.enemies.Koopa;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Tree extends Ground {
    TreeTypes treeState;
    int tickcount;
    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        treeState=TreeTypes.SPROUT;
        tickcount=0;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
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

    public int getTick() {
        return tickcount;
    }

    @Override
    public void tick(Location location) {
//        for (int i=0;i<location.getExits().size();i++){
//            System.out.println(location.getExits().get(i).getName());
//        }
//        System.out.println(location.getExits().get(0).getName());
        if (treeState==TreeTypes.DEAD){
            return;
        }

        //create random double for chance
        Random random=new Random();
        double probability=random.nextDouble();
        this.tickcount+=1;

        if (tickcount<=10){ //sprout
            sprout(probability,location);
        } else if (tickcount<=20){ //sapling
            sapling(probability,location);
            treeState=TreeTypes.SAPLING;
            super.setDisplayChar('t');
        } else { //mature
            mature(probability,location);
            treeState=TreeTypes.MATURE;
            super.setDisplayChar('T');
        }
    }

    public void sprout(double probability, Location location){
        if (probability<=0.1 & !location.containsAnActor()){ //10% chance to spawn goomba
            location.addActor(new Goomba());
        }
    }

    public void sapling(double probability, Location location){
        if (tickcount>10 & tickcount<=20){ //sapling stage
            treeState=TreeTypes.SAPLING;
            if (probability<=0.1){ //10% chance to spawn $20 coin
                //todo location.addItem(new Coin());
            }
        }
    }

    public void mature(double probability, Location location){
        if (this.tickcount>=20){ //mature stage
            treeState=TreeTypes.MATURE;
            if (probability<=0.15 & !location.containsAnActor()){ //15% chance to spawn koopa
                location.addActor(new Koopa());
            }

            if (this.tickcount%5==0){ //turn tiles around it
                grownew(location);
            }
            //System.out.println(probability);
            if (probability<=0.2){ //chance to wither
                treeState=TreeTypes.DEAD;
                super.setDisplayChar('.');
                location.setGround(new Dirt());
                //System.out.println("dead: "+location.x()+" "+location.y());
            }
        }
    }

    public void grownew(Location location){
        ArrayList<Location> fertileLocations=new ArrayList<>();

        for (int i=0;i<location.getExits().size();i++){ //adds all possible exits with fertile ground into arraylist
            if (location.getExits().get(i).getDestination().getDisplayChar()=='.'){
                fertileLocations.add(location.getExits().get(i).getDestination()); //adds location class of the location to arraylist
            }
        }
        if (fertileLocations.size()==0){ //if no fertile ground around, cant grow
            return;
        }
        Random random=new Random();
        int index=random.nextInt(fertileLocations.size());
        fertileLocations.get(index).setGround(new Tree());
        //System.out.println("new tree at:"+fertileLocations.get(index).x()+" "+fertileLocations.get(index).y());
    }
}
