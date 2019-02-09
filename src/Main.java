import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(//"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
                // handle exception
            }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame();

            }
        });

    }
}
