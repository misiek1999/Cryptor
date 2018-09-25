import javax.swing.*;
import java.awt.*;

public class TextArea extends JPanel {
    String path;
    String text;
    FilesHelper file;
    javax.swing.JTextArea area;
    public TextArea (){
        //Read text from file
        path = "backup.txt";
        file = new FilesHelper(path);
        text = file.readAllFile();
        //text = "ELOSZKI \nWitam";

        //Setup JtextArea
        area = new javax.swing.JTextArea(30,60);
        area.setText(text);
        area.setLineWrap(true);
        //area.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0,0,1000,1000);
        add(scrollPane);

        setVisible(true);
    }
    public void saveToFile()
    {
        file.save(area.getText());
    }
}
