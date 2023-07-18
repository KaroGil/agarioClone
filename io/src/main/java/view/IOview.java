package view;

import javax.swing.JComponent;

import model.IOmodel;
import model.components.Orb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class IOview extends JComponent{

    private IOmodel model;
    
    public IOview(IOmodel model){
        this.setFocusable(true);
        this.model = model;
    }

     @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        praintOrbs(g, model.getOrbs());
        paintPlayer(g, model.getPlayerColor(), model.getPlayerX(), model.getPlayerY(), model.getPlayerRadius());
        paintScore(g, Color.WHITE);
    }

     @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    private void paintPlayer(Graphics g, Color color, int x, int y, int r){
        g.setColor(color);
        g.fillOval(x, y, r, r);
    }


    private void paintScore(Graphics g, Color color){
        g.setColor(color);
        g.setFont(new Font("New Times Roman", 1, 50));
        //have to toString int and it's impossible (with spanish/french accent) on this flight rn
        g.drawString("10", getWidth()/2 - getFont().getSize(), 50);
    }


    private void praintOrbs(Graphics g, ArrayList<Orb> orbsList){
        for (Orb orb : orbsList) {
            int r = orb.getRadius();
            g.setColor(orb.getColor());
            g.fillOval(orb.getX(), orb.getY(), r, r);
        }
    }
}
