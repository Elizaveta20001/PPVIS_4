import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RadioAction implements ActionListener {
    private Buttons panel;
    private Window window;
    private Tree tree;

    public RadioAction(Buttons panel, Window window, Tree tree) {
        this.panel = panel;
        this.window = window;
        this.tree = tree;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (panel.getTrigonometricFunction().isSelected()) {
            panel.getPanel().remove(panel.getPanel().getComponentCount() - 1);
            Box customPanel = Box.createHorizontalBox();
            customPanel.add(panel.mainPanel());
            customPanel.add(panel.trigomometricFunctionsPanel());

            panel.getPanel().add(customPanel);

            Dimension panelDimension = new Dimension(panel.mainPanel().getWidth() + panel.trigomometricFunctionsPanel().getWidth(), panel.getPanel().getHeight());
            panel.getPanel().setMinimumSize(panelDimension);
            panel.getPanel().setSize(panelDimension);

            Dimension frameDimension = new Dimension(tree.getTree().getWidth() + panel.getPanel().getWidth() + 14, window.getFrame().getHeight());
            window.getFrame().setMinimumSize(frameDimension);
            window.getFrame().setSize(frameDimension);
            panel.getPanel().validate();
        } else {
            panel.getPanel().remove(panel.getPanel().getComponentCount() - 1);
            panel.getPanel().add(panel.mainPanel());

            Dimension panelDimension = new Dimension(panel.mainPanel().getWidth(), panel.getPanel().getHeight());
            panel.getPanel().setMinimumSize(panelDimension);
            panel.getPanel().setSize(panelDimension);

            Dimension frameDimension = new Dimension(tree.getTree().getWidth() + panel.getPanel().getWidth() + 14, window.getFrame().getHeight());
            window.getFrame().setMinimumSize(frameDimension);
            window.getFrame().setSize(frameDimension);
            panel.getPanel().validate();
        }
    }
}