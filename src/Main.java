import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame();

            }
        });

    }
}
