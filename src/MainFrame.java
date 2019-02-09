import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;


public class MainFrame extends JFrame {
    private javax.swing.JTextArea textArea;
    private JButton encryptionButton;
    private JButton saveButton;
    private JButton decryptionButton;
    private JPanel MainPanel;
    private JTextField keyText;
    private JScrollPane scrollTextArea;

    private FilesHelper helper = new FilesHelper("backup.txt");


    public MainFrame(){
        super("Hello");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Better Than JS");
        setResizable(false);
        setSize(640,480);




        add(MainPanel);



        addWindowListener(new listener());
        decryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = MyStringCrypto.decrypt(textArea.getText(),keyText.getText());
                if (temp !=null){
                    textArea.setText(temp);
                }

            }
        });
        setVisible(true);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helper.save(textArea.getText());
                JFileChooser fileChooser  =new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    helper = new FilesHelper(file.getPath());
                    helper.save(textArea.getText());
            }
        }});


        encryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = MyStringCrypto.encrypt(textArea.getText(),keyText.getText());
                if (temp !=null){
                    textArea.setText(temp);
                }
            }
        });
    }
    private class listener implements WindowListener{


       @Override
       public void windowOpened(WindowEvent e) {
           //String text =  new String( helper.readAllFile());
           textArea.setText(helper.readAllFile());
       }

       @Override
       public void windowClosing(WindowEvent e) {
        helper.save(textArea.getText());

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
