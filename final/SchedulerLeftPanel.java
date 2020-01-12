import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the left panel with the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class SchedulerLeftPanel extends JPanel{
  /**
   * Constructs an instance of the SchedulerLeftPanel
  */
  public SchedulerLeftPanel(View parentView){
    this.parentView           = parentView;
    todayListPanel            = new TaskListPanel(parentView, 0, TODAY_LIST_PANEL_LABEL);
    tomorrowListPanel         = new TaskListPanel(parentView, 1, TOMORROW_LIST_PANEL_LABEL);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(todayListPanel);
    add(tomorrowListPanel);
    setVisible(true);
  }

  public void refresh(){
    todayListPanel.refresh();
    tomorrowListPanel.refresh();
  }

  /**
   * Returns the upper list panel
   * @return todayListPanel
  */
  public JPanel getTodayListPanel(){
    return todayListPanel;
  }

  /**
   * Returns the lower list panel
   * @return tomorrowListPanel
  */
  public JPanel getTomorrowListPanel(){
    return tomorrowListPanel;
  }

  private TaskListPanel todayListPanel;
  private TaskListPanel tomorrowListPanel;
  private View parentView;

  private final static String TODAY_LIST_PANEL_LABEL = "TODAY";
  private final static String TOMORROW_LIST_PANEL_LABEL = "TOMORROW";
  private final static int NUM_ROWS = 2;
  private final static int NUM_COLS = 1;
}
