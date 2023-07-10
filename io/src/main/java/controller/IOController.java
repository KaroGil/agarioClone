package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IOmodel;
import view.IOview;

public class IOController implements KeyListener {

    private IOmodel model;
    private IOview view;

    public IOController(IOmodel model, IOview view) {
        this.model = model;
        this.view = view;
        this.view.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // if(keyCode == KeyEvent.VK_LEFT){model.move(-1, 0);}
        // if(keyCode == KeyEvent.VK_RIGHT){model.move(1,0);}
        // if(keyCode == KeyEvent.VK_UP){model.move(0,-1);}
        // if(keyCode == KeyEvent.VK_DOWN){model.move(0,1);}
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                model.move(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                model.move(1,0);
                break;
            case KeyEvent.VK_UP:
                model.move(0,-1);
                break;
            case KeyEvent.VK_DOWN:
                model.move(0,1);
                break;
            default:
                break;
        }
        
        this.view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
