package model;

import java.awt.Color;

public class Player {
    
    private int x,y,radius;
    private Color color;
    private int speed;

    public Player(int x, int y,int radius, Color color, int speed){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.speed = speed;
    }

    public void setColor(Color newColor){
        this.color = newColor;
    }

    public Color getColor(){
        return this.color;
    }

    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setRadius(int r){
        this.radius = r;
    }

    //also should check for collisions with items on the screens like the orbs:)


    public void movePlayer(int dx, int dy){
        //should add a clause that checks whether the player doesn't move outside the screen
        this.x += dx;
        this.y += dy;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getRadius(){
        return this.radius;
    }

}
