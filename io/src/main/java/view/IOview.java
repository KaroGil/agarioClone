package view;

import javax.swing.JComponent;

import model.IOmodel;
import java.awt.Dimension;
import java.awt.Graphics;

public class IOview extends JComponent{

    private IOmodel model;
    
    public IOview(IOmodel model){
        this.setFocusable(true);
        this.model = model;
    }

     @Override
    public void paint(Graphics g) {
        super.paint(g);

        int r = model.getPlayerRadius();

        g.setColor(model.getPlayerColor());
        g.fillOval(model.getPlayerX(), model.getPlayerY(), r, r);
    }

     @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

}
