package model.components;

import java.awt.Color;
import java.util.Random;

public class Orb {
    
    private int x,y,radius;
    private Color color;
    private int points;

    private final Color[] COLORS = {Color.pink, Color.CYAN, Color.yellow, Color.magenta, Color.GREEN};

    public Orb(int x, int y, int points){
        this.x = x;
        this.y = y;
        this.color = pickRandomColor();
        this.points = points;
        determineRadius();
    }

    private Color pickRandomColor(){
        int rnd = new Random().nextInt(COLORS.length);
        return COLORS[rnd];
    }

    private void determineRadius(){
        switch (points) {
            case 10:
                this.radius = 10;
                break;
            case 20:
                this.radius = 25;
                break;
            default:
                break;
        }
    }
    

    public int getX(){
        return this.x;
    }


    public int getY(){
        return this.y;
    }


    public Color getColor(){
        return this.color;
    }


    public int getRadius(){
        return this.radius;
    }


    public int getPoints(){
        return this.points;
    }

}
