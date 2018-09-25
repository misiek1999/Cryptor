import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

public class MainFrame extends JFrame {
    TextArea textArea;
    public MainFrame(){
        super("Hello");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Better Than JS");
        setResizable(false);
        textArea = new TextArea();
        add(textArea);
        pack();
        setVisible(true);

        addWindowListener(new listener());
    }

   private class listener implements WindowListener{


       @Override
       public void windowOpened(WindowEvent e) {

       }

       @Override
       public void windowClosing(WindowEvent e) {
           textArea.saveToFile();

       }

       @Override
       public void windowClosed(WindowEvent e) {

       }

       @Override
       public void windowIconified(WindowEvent e) {

       }

       @Override
       public void windowDeiconified(WindowEvent e) {

       }

       @Override
       public void windowActivated(WindowEvent e) {

       }

       @Override
       public void windowDeactivated(WindowEvent e) {

       }
   }

}
