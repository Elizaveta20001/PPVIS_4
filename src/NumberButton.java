import javax.swing.*;
import java.awt.*;
public class NumberButton {
    private  JButton numberButton;
    public NumberButton(String number) {
        numberButton = new JButton(number);
        numberButton.setSize(60,60);
        numberButton.setPreferredSize(new Dimension(60,60));
    }
    public JButton getButton(){
        return numberButton;
    }
}