import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsertAction implements ActionListener {

    private JButton button;
    private Screen screen;
    public InsertAction(JButton button, Screen screen) {
        this.button = button;
        this.screen = screen;
    }
    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand();
        screen.getScreen().setText(screen.getScreen().getText() + input);
    }
}