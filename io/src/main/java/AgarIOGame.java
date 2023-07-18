import javax.swing.JFrame;

import controller.IOController;
import model.IOmodel;
import view.IOview;

public class AgarIOGame {
    
    public static final String WINDOW_TITLE = "Agar.io clone";

    public static void main(String[] args) {
        IOmodel model = new IOmodel();
        IOview view = new IOview(model);
        IOController controller = new IOController(model, view);
        
        // The JFrame is the "root" application window.
        // We here set some properties of the main window, 
        // and tell it to display our view
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
      
        frame.pack();
        frame.setVisible(true);

    }

}
