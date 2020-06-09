import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Action implements ActionListener {
    private static Parse parse;
    private JButton button;
    private Screen screen;
    private Tree tree;
    private String value;
    private String prevText;
    private DefaultMutableTreeNode child;
    private DefaultMutableTreeNode parent;
    private static Logger log = Logger.getLogger(Action.class.getName());

    public Action(JButton button, Screen screen, Tree tree) {
        this.button = button;
        this.screen = screen;
        this.tree = tree;
        parse = new Parse(tree);
    }
    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand();
        switch (button.getText()) {
            case "+":

            case "-":

            case "*":

            case "/":

            case "%":
                screen.getScreen().setText(screen.getScreen().getText() + input);
                break;

            case "sin":

            case "cos":

            case "tan":

            case "sinh":

            case "cosh":

            case "tanh":
                screen.getScreen().setText(screen.getScreen().getText() + input + "(");
                break;

            case "=":

                try {
                    if (tree.getExpressions().size() != 0) {
                        tree.getExpressions().removeLast();
                        if (tree.getExpressions().getLast() != screen.getScreen().getText())
                            tree.getExpressions().add(screen.getScreen().getText());
                    } else
                        tree.getExpressions().add(screen.getScreen().getText());
                    screen.getScreen().setText(String.valueOf(parse.parsing(screen.getScreen().getText())));
                    tree.update();
                } catch (NumberFormatException e) {
                    log.log(Level.INFO, "Error", e);
                }
                break;
                case "C":
                    screen.getScreen().setText("");
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().setUserObject("=");
                    tree.update();
                    parse = new Parse(tree);
                    while (tree.getExpressions().size() != 0)
                        tree.getExpressions().removeLast();
                    break;

            case "DEL":
                try {
                    if (!screen.getScreen().getText().equals("")) {
                        value = String.valueOf(screen.getScreen().getText().substring(0, screen.getScreen().getText().length() - 1));
                        screen.getScreen().setText(value);
                        tree.getRoot().setUserObject(value);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    log.log(Level.INFO, "Errer", e);
                }
                break;

            case "sqrt":
                prevText = screen.getScreen().getText();
                value = String.valueOf(Math.sqrt(Double.parseDouble(screen.getScreen().getText())));
                screen.getScreen().setText(value);
                tree.getRoot().setUserObject(value);
                if (tree.getRoot().getChildCount() == 0) {
                    child = new DefaultMutableTreeNode(prevText);
                }
                else {
                    child = tree.getRoot().getNextNode();
                }
                parent = new DefaultMutableTreeNode(value);
                parent.add(child);
                tree.getRoot().removeAllChildren();
                tree.getRoot().add(parent);
                tree.update();
                break;

            case "1/x":
                try {
                    prevText = screen.getScreen().getText();
                    value = String.valueOf(1 / Double.parseDouble(screen.getScreen().getText()));
                    screen.getScreen().setText(value);
                    tree.getRoot().setUserObject(value);
                    if (tree.getRoot().getChildCount() == 0)
                        child = new DefaultMutableTreeNode(prevText);
                    else {
                        child = tree.getRoot().getNextNode();
                    }
                    parent = new DefaultMutableTreeNode(value);
                    parent.add(child);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);
                    tree.update();
                } catch (NumberFormatException e) {
                    log.log(Level.INFO, "Error", e);
                }
                break;
        }
    }
}

