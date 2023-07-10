package model;

import java.awt.Color;
import java.util.ArrayList;

import model.components.Orb;

public class IOmodel {

    private Player player;
    private ArrayList<Orb> orbs;

    public IOmodel(){
        this.player = new Player(10,10,25,Color.BLUE, 3);
        this.orbs = new ArrayList<Orb>();
        spawnOrb();
    }
    


    public void move(int dx, int dy){
        player.movePlayer(dx, dy);
    }

    public int getPlayerX(){
        return player.getX();
    }

    public int getPlayerY(){
        return player.getY();
    }

    public int getPlayerRadius(){
        return player.getRadius();
    }

    public Color getPlayerColor(){
        return player.getColor();
    }

    public Orb spawnOrb(){
        //before making orb check if there isnt an orb or player already on that position
        Orb orb = new Orb(100, 100, 10);
        orbs.add(orb);
        return orb;
    }
}