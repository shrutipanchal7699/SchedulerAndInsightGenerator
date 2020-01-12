import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the journal panel
 * @author Akshat Bansal
*/
public class JournalPanel extends JPanel{
  /**
   * Constructs an instance of the JournalPanel
   * @param parentView the parent view of this journal panel
  */
  public JournalPanel(View parentView){
    this.parentView = parentView;
    journalLeftPanel = new JournalLeftPanel(this.parentView);
    journalRightPanel = new JournalRightPanel(this.parentView);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(journalLeftPanel);
    add(journalRightPanel);
    setVisible(true);
  }

  /**
   * Returns the right panel of the journal panel
   * @return journalRightPanel
  */
  public JournalRightPanel getRightPanel(){
    return journalRightPanel;
  }

  /**
   * Returns the left panel of the journal panel
   * @return journalLeftPanel
  */
  public JournalLeftPanel getLeftPanel(){
    return journalLeftPanel;
  }

  private JournalLeftPanel journalLeftPanel;
  private JournalRightPanel journalRightPanel;
  private View parentView;

  private static final int NUM_ROWS = 1;
  private static final int NUM_COLS = 2;

}
