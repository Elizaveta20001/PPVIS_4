import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
public class Main {
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new GTKLookAndFeel());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Window window = new Window();
    }
}

