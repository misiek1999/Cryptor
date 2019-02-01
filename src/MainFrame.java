import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollTextArea;
    private JButton encryptionButton;
    private JButton saveButton;
    private JButton decryptionButton;
    private JPanel MainPanel;
    private JTextField keyText;


    //private JTextArea textArea1;

    public MainFrame(){
        super("Hello");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Better Than JS");
        setResizable(false);
        setSize(640,480);
        //textArea = new TextArea();
        //add(textArea);
        //scrollTextArea.setVerticalScrollBarPolicy(scrollTextArea.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea = new JTextArea();
        textArea.setRows(30);
        textArea.setColumns(64);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollTextArea = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollTextArea);
        add(MainPanel);
        //pack();
        setVisible(true);

        addWindowListener(new listener());
    }



    private class listener implements WindowListener{


       @Override
       public void windowOpened(WindowEvent e) {

       }

       @Override
       public void windowClosing(WindowEvent e) {
          // textArea.saveToFile();

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
