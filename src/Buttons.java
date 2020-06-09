import javax.swing.*;
import java.awt.*;

public class Buttons {
    private final static String COMMAND = "command";
    private final static String INSERT = "insert";
    private JRadioButton trigonometricFuntions;
    private Box buttons;
    private Screen screen;
    private Tree tree;
    public Buttons(Screen screen, Window window, Tree tree) {
        buttons = Box.createVerticalBox();
        this.screen = screen;
        this.tree=tree;
        trigonometricFuntions = new JRadioButton("Trigonometric functions");
        trigonometricFuntions.addActionListener(new RadioAction(this, window,tree));
        buttons.add(extraPanel());
        buttons.add(mainPanel());
    }

    private Box extraPanel() {
        Box extrapanel = Box.createHorizontalBox();
        extrapanel.add(trigonometricFuntions);
        extrapanel.add(Box.createHorizontalGlue());
        return extrapanel;
    }
    private void addButton(JPanel panel, String label, String listener) {
        NumberButton button = new NumberButton(label);
        switch (listener) {
            case Buttons.INSERT:
                button.getButton().addActionListener(new InsertAction(button.getButton(), screen));
                break;
            case Buttons.COMMAND:
                button.getButton().addActionListener(new Action(button.getButton(), screen,tree));
                break;
        }
        panel.add(button.getButton());
    }
    public Box getPanel() {
        return buttons;
    }
    public JPanel mainPanel() {
        JPanel simplePanel = new JPanel();
        simplePanel.setLayout(new GridLayout(5, 5, 3, 3));
        addButton(simplePanel, "DEL", Buttons.COMMAND);
        addButton(simplePanel, "C", Buttons.COMMAND);
        addButton(simplePanel, "(", Buttons.INSERT);
        addButton(simplePanel, ")", Buttons.INSERT);
        addButton(simplePanel, "sqrt", Buttons.COMMAND);
        addButton(simplePanel, "7", Buttons.INSERT);
        addButton(simplePanel, "8", Buttons.INSERT);
        addButton(simplePanel, "9", Buttons.INSERT);
        addButton(simplePanel, "*", Buttons.INSERT);
        addButton(simplePanel, "/", Buttons.INSERT);
        addButton(simplePanel, "4", Buttons.INSERT);
        addButton(simplePanel, "5", Buttons.INSERT);
        addButton(simplePanel, "6", Buttons.INSERT);
        addButton(simplePanel, "+", Buttons.COMMAND);
        addButton(simplePanel, "-", Buttons.COMMAND);
        addButton(simplePanel, "1", Buttons.INSERT);
        addButton(simplePanel, "2", Buttons.INSERT);
        addButton(simplePanel, "3", Buttons.INSERT);
        addButton(simplePanel, "%", Buttons.COMMAND);
        addButton(simplePanel, "1/x", Buttons.COMMAND);
        addButton(simplePanel, "0", Buttons.INSERT);
        addButton(simplePanel, ".", Buttons.INSERT);
        addButton(simplePanel, "=", Buttons.COMMAND);
        Dimension simpleDimension = new Dimension(312, 312);
        simplePanel.setSize(simpleDimension);
        simplePanel.setMinimumSize(simpleDimension);
        return simplePanel;
    }
    public JPanel trigomometricFunctionsPanel() {
        JPanel trigonometricFunctionPanel = new JPanel();
        trigonometricFunctionPanel.setLayout(new GridLayout(5, 2, 3, 3));
        addButton(trigonometricFunctionPanel, "sin", Buttons.COMMAND);
        addButton(trigonometricFunctionPanel, "cos", Buttons.COMMAND);
        addButton(trigonometricFunctionPanel, "tan", Buttons.COMMAND);
        addButton(trigonometricFunctionPanel, "sinh", Buttons.COMMAND);
        addButton(trigonometricFunctionPanel, "cosh", Buttons.COMMAND);
        addButton(trigonometricFunctionPanel, "tanh", Buttons.COMMAND);
        Dimension trigDemension = new Dimension(123, 259);
        trigonometricFunctionPanel.setSize(trigDemension);
        trigonometricFunctionPanel.setMinimumSize(trigDemension);
        return trigonometricFunctionPanel;
    }

    public JRadioButton getTrigonometricFunction() {
        return trigonometricFuntions;
    }
}