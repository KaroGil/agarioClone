package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.components.Orb;

public class IOmodel {

    private Player player;
    private ArrayList<Orb> orbs;
    private int score;
    private int spawnCount;


    public IOmodel(){
        this.player = new Player(10,10,25,Color.BLUE, 3);
        this.orbs = new ArrayList<Orb>();
        for(int i = 0; i < 10; i++){ spawnOrb(600,10);}
       
        spawnCount = 0;
        score = 0;
    }
    
    //also should check for collisions with items on the screens like the orbs:)

    private boolean checkBounds(int x, int y, int width, int height, int boundX, int boundY){
        if(x < 0 || x+width > boundX || y < 0 || y+height > boundY){ 
            return false; 
        }
        return true;
    }

    private boolean checkCollisionWithOrb(){
        for (Orb orb : orbs) {
            if(player.getX() + player.getRadius() > orb.getX() && (player.getX() < orb.getX() + orb.getRadius()) && player.getY()+ player.getRadius() > orb.getY()  && player.getY() < orb.getY() + orb.getRadius()){
                orbs.remove(orb);
                int points = orb.getPoints();
                player.grow(points);
                setScore(points);
                return true;
            }
        }
        return false;
    }

    //later should add a "camera" so we can go in and out of the "map"
    public void move(int dx, int dy){
        if(checkBounds( player.getX()+dx, player.getY()+dy, player.getRadius(), player.getRadius(), 600, 600)){
            player.movePlayer(dx, dy);
        }
        checkCollisionWithOrb();
    }

    private void setScore(int points){
        this.score += points;
    }

    public int getScore(){
        return this.score;
    }


    
    /**
     * This method will check whether players collide
     * and preform the actions accordingly
     * @param p1 player 1
     * @param p2 player 2 
     */
    private void battle(Player p1, Player p2){
        if(p1.checkPLayerCollision(p2)){
            Player biggest = p1.compareRadius(p2);//idk
        }
    }
    

    public int getPlayerSpeed(){
        return this.player.getSpeed();
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

    //now we need a timer that spawns orbs regulary
    public Orb spawnOrb(int bounds, int points){
        if(orbs.size() < 100){
            Random rand = new Random(); 
            int int_random_x = rand.nextInt(bounds); 
            int int_random_y = rand.nextInt(bounds); 
            //before making orb check if there isnt an orb or player already on that position
            Orb orb = new Orb(int_random_x, int_random_y, points);
            orbs.add(orb);
            spawnCount++;
            return orb;
        }
        return null;
    }

    public void clockTick(){
        
        if(spawnCount < 10){
            spawnOrb(600,10);
        }else{
            spawnOrb(600,20);
            spawnCount = 0;
        }
    }


    public ArrayList<Orb> getOrbs(){
        return this.orbs;
    }
}