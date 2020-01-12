import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerPanel extends JPanel{
  /**
   * Constructs an instance of the SchedulerPanel
  */
  public SchedulerPanel(View parentView){
    this.parentView = parentView;

    schedulerLeftPanel = new SchedulerLeftPanel(parentView);
    schedulerRightPanel = new SchedulerRightPanel(parentView);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(schedulerLeftPanel);
    add(schedulerRightPanel);
    setVisible(true);
  }

  /**
   * Returns the left panel of the scheduler panel
   * @return schedulerLeftPanel
  */
  public SchedulerLeftPanel getLeftPanel(){
    return schedulerLeftPanel;
  }

  /**
   * Returns the right panel of the scheduler panel
   * @return schedulerRightPanel
  */
  public SchedulerRightPanel getRightPanel(){
    return schedulerRightPanel;
  }

  private View parentView;
  private SchedulerLeftPanel schedulerLeftPanel;
  private SchedulerRightPanel schedulerRightPanel;

  private final static int NUM_ROWS = 1;
  private final static int NUM_COLS = 2;

  /**
   * Test layouts of the left and the right panel here
  */
  public static void main(String[] args){
    Model model = new Model();
    View view = new View(model);
    Controller controller = new Controller(model, view);
  }
}
