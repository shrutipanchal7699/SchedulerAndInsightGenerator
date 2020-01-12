
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the wall with all the list panels in the scheduler panel
 * @author Akshat Bansal
*/
public class JournalLeftPanel extends JPanel{
  /**
   * Constructs an instance of the JournalLeftPanel
   * @param parentView the parent view of this journal left panel
  */
  public JournalLeftPanel(View parentView){
    this.parentView = parentView;
    topPanel = new JournalTopLeftPanel(this.parentView);
    bottomPanel = new JournalBottomLeftPanel(this.parentView, "Add Reminders");

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(topPanel);
    add(bottomPanel);
    setVisible(true);
  }

  public JournalBottomLeftPanel getBottomPanel(){
    return bottomPanel;
  }

  public void refresh(){
    topPanel.refresh();
  }


  private JournalTopLeftPanel topPanel;
  private JournalBottomLeftPanel bottomPanel;
  private View parentView;

  private static final int NUM_ROWS = 2;
  private static final int NUM_COLS = 1;
}
