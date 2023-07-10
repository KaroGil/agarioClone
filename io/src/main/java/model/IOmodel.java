package model;

import java.awt.Color;

public class IOmodel {

    private Player player;

    public IOmodel(){
        this.player = new Player(10,10,25,Color.BLUE, 3);
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
}