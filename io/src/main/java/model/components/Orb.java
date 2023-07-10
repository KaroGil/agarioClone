package model.components;

import java.awt.Color;

public class Orb {
    
    private int x,y,radius;
    private Color color;
    private int points;

    public Orb(int x, int y, Color color, int points){
        this.x = x;
        this.y = y;
        this.color = color;
        this.points = points;

        determineRadius();
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


}
