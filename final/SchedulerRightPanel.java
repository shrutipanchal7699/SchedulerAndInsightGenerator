import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the panel with the graph and the buttons on the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerRightPanel extends JPanel{
  /**
   * Constructs an instance of the SchedulerRightPanel
  */
  public SchedulerRightPanel(View parentView){
    this.parentView = parentView;

    graphPanel = new BarGraph(parentView, GRAPH_TITLE);
    graphPanel.setBackground(new Color(131, 133, 126));
    buttonPanel = new ButtonPanel(parentView);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(graphPanel);
    add(buttonPanel);
    setVisible(true);
  }

  /**
   * Returns the graph panel
   * @return graphPanel
  */
  public BarGraph getGraphPanel(){
    return graphPanel;
  }

  /**
   * Returns the button panel
   * @return buttonPanel
  */
  public ButtonPanel getButtonPanel(){
    return buttonPanel;
  }

  private BarGraph graphPanel;
  private ButtonPanel buttonPanel;
  private View parentView;

  private final static int NUM_ROWS = 2;
  private final static int NUM_COLS = 1;
  private final static String GRAPH_TITLE = "Workload for upcoming week";
}
