import javax.swing.*;

public class Calculator {
    private Box calculatorPanel;
    private Screen calculatorScreen;
    private Buttons buttons;

    public Calculator(Window window,Tree tree) {
        calculatorPanel = Box.createVerticalBox();
        calculatorScreen = new Screen();
        buttons = new Buttons(calculatorScreen, window, tree);

        calculatorPanel.add(calculatorScreen.getScreen());
        calculatorPanel.add(Box.createVerticalStrut(6));
        calculatorPanel.add(buttons.getPanel());
    }

    public Box getPanel() {
        return calculatorPanel;
    }
    public  Screen getScreen(){
        return calculatorScreen;
    }
}