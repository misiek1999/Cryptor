import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;


public class MainFrame extends JFrame {
    private JTextArea textEncrypt;
    private JButton encryptionButton;
    private JButton saveButton;
    private JButton decryptionButton;
    private JPanel MainPanel;
    private JTextArea textDecrypt;
    private JTextField keyText;
    private JScrollPane scrollEncrypt;
    private JScrollPane scrollDecrypt;
    private JToolBar toolBar;
    private JButton saveToFileButton;

    private FilesHelper helper = new FilesHelper("backup.txt");


    public MainFrame(){
        super("Hello");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Better Than JS");
        setResizable(false);
        setSize(800,600);

        InputMap inPut = MainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inPut.put(KeyStroke.getKeyStroke("ctrl shift pressed S"),"scs");
        MainPanel.getActionMap().put("scs", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                helper.save(textDecrypt.getText());
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    helper = new FilesHelper(file.getPath());
                    helper.save(textDecrypt.getText());
                    }
            }
        });
        add(MainPanel);



        addWindowListener(new listener());
        decryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = MyStringCrypto.decrypt(textDecrypt.getText(),keyText.getText());
                if (!temp.isEmpty()){
                    textEncrypt.setText(temp);
                }

            }
        });
        setVisible(true);
/*        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helper.save(textDecrypt.getText());
                JFileChooser fileChooser  =new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    helper = new FilesHelper(file.getPath());
                    helper.save(textDecrypt.getText());
            }
        }});        */


        encryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = MyStringCrypto.encrypt(textEncrypt.getText(),keyText.getText());
                if (!temp.isEmpty()){
                    textDecrypt.setText(temp);

                }
            }
        });
    }
    private class listener implements WindowListener{


       @Override
       public void windowOpened(WindowEvent e) {
           textEncrypt.setText(helper.readAllFile());
       }

       @Override
       public void windowClosing(WindowEvent e) {
            helper.save(textEncrypt.getText());
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
