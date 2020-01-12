import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the wall with all the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class JournalTopLeftPanel extends JPanel{
  /**
   * Constructs an instance of the JournalTopLeftPanel
   * @param parentView the parent view of the JournalPanel
  */
  public JournalTopLeftPanel(View parentView){
    this.parentView = parentView;
    todayActivityListPanel      = new ActivityListPanel(this.parentView, TODAY_ACTIVITY_LIST_LABEL);
    //yesterdayActivityListPanel  = new ActivityListPanel(this.parentView, YESTERDAY_ACTIVITY_LIST_LABEL);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(todayActivityListPanel);
    //add(yesterdayActivityListPanel);
    setVisible(true);
  }

  public void refresh(){
    todayActivityListPanel.refresh();
    //yesterdayActivityListPanel.refresh();
  }

  public ActivityListPanel getTodayActivityListPanel(){
    return todayActivityListPanel;
  }

  /*
  public ActivityListPanel getYesterdayActivityListPanel(){
    return yesterdayActivityListPanel;
  }
  */

  private ActivityListPanel todayActivityListPanel;
  //private ActivityListPanel yesterdayActivityListPanel;
  private View parentView;

  public static final int NUM_ROWS = 1;
  public static final int NUM_COLS = 2;

  public static final String TODAY_ACTIVITY_LIST_LABEL = "Today";
  public static final String YESTERDAY_ACTIVITY_LIST_LABEL = "Yesterday";
}
