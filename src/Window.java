import javax.swing.*;
import java.awt.*;
public class Window {

    private JFrame mainWidnow = new JFrame();
    public Window() {
        mainWidnow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Tree treePanel=new Tree();
        Calculator calculator=new Calculator(this,treePanel);
        Box boxPanel=Box.createHorizontalBox();

        JScrollPane treeScrollPane=new JScrollPane(treePanel.getTree());
        treeScrollPane.setPreferredSize(new Dimension(200, 250));

        boxPanel.add(treeScrollPane);
        boxPanel.add(Box.createHorizontalStrut(12));
        boxPanel.add(calculator.getPanel());
        treePanel.getTree().addTreeExpansionListener(new TreeListener(treePanel,calculator.getScreen()));
        mainWidnow.setContentPane(boxPanel);
        mainWidnow.pack();
        mainWidnow.setVisible(true);
    }
    public JFrame getFrame(){
        return mainWidnow;
    }
}