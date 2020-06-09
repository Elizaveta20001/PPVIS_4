import javax.swing.*;

import java.awt.*;
public class Screen {

    private JScrollPane scrollPane;
    private JTextField screen;
    public Screen(){
        screen=new JTextField();
        screen.setEnabled(false);
        screen.setPreferredSize(new Dimension(200,100));
        screen.setSize(210,100);
    }
    public JTextField getScreen(){
        return screen;
    }
}
