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

    public void movePlayer(int dx, int dy){        
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

    public void grow(int points){
        if(radius < 300){
            switch (points) {
                case 10:
                    setRadius(getRadius()+2);
                    break;
                case 20:
                    setRadius(getRadius()+5);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * this method compares the radius of two players (meaning how big they are) 
     * and returns the player with the biggest radius
     * @param p other player 
     * @return biggest player
     */
    public Player compareRadius(Player p){
        if(this.getRadius() > p.getRadius()){
            return this;
        }
        return p;
    }

    public boolean checkPLayerCollision(Player p){
        if(this.getX() + this.getRadius() > p.getX() && (this.getX() < this.getX() + p.getRadius()) && this.getY()+ this.getRadius() > p.getY()  && this.getY() < p.getY() + p.getRadius()){
            return true;
        }
        return false;
    }

}
