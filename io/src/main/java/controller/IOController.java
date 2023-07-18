package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import model.IOmodel;
import view.IOview;

public class IOController implements KeyListener, ActionListener {

    private IOmodel model;
    private IOview view;

    private boolean right;
    private boolean up;
    private boolean down;
    private boolean left;

    private int speed;
    private Timer timer;


    public IOController(IOmodel model, IOview view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(2000,this);
        this.view.addKeyListener(this);     
        timer.start();   //this b
        
        this.right = false;
        this.left = false;
        this.down = false;
        this.up = false;
        setTimerDelay();
        this.speed = model.getPlayerSpeed();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right =  true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            default:
                break;
        }
        move();
        this.view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right =  false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            default:
                break;
        }
    }


    private void move(){
        if (left && up) {
            model.move(-speed,-speed);
        } else if (left && down) {
            model.move(-speed, speed);
        } else if (right && up) {
            model.move(speed, -speed);
        } else if (right && down) {
            model.move(speed,speed);
        } else if (left) {
            model.move(-speed, 0);
        } else if (up) {
            model.move(0, -speed);
        } else if (right) {
           model.move(speed, 0);
        } else if (down) {
           model.move(0, speed);
        } 
    }

    private void setTimerDelay() {
        int ms = 2000;
        this.timer.setDelay(ms);
        this.timer.setInitialDelay(ms);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            this.model.clockTick();
            this.view.repaint();
    }
    
}
