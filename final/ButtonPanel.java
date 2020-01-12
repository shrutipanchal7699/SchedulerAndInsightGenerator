import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the panel with the progress bar and the buttons in the scheduler panel
 * @author Akshat Bansal
*/
public class ButtonPanel extends JPanel{
  /**
   * Constructs an instance of the ButtonPanel
  */
  public ButtonPanel(View parentView){
    this.parentView = parentView;
    progressBar = new JProgressBar(MIN_PROGRESS, MAX_PROGRESS);
    addBtn = new JButton(ADD_BTN_LABEL);
    clockInBtn = new JButton(CLOCK_IN_BTN_LABEL);

    progressBar.setStringPainted(true);
    progressBar.setValue(INITIAL_PROGRESS);

    setLayout(new GridLayout(NUM_ROWS,NUM_COLS));
    add(progressBar);
    add(addBtn);
    add(clockInBtn);

    setVisible(true);
    setBackground(Color.DARK_GRAY);
  }

  /**
   * Returns the add button
   * @return addBtn
  */
  public JButton getAddBtn(){
    return addBtn;
  }

  /**
   * Returns the clock in buttton
   * @return clockInBtn
  */
  public JButton getClockInBtn(){
    return clockInBtn;
  }

  private JProgressBar progressBar;
  private JButton addBtn;
  private JButton clockInBtn;
  private View parentView;

  private final static int NUM_ROWS = 3;
  private final static int NUM_COLS = 1;
  private final static int INITIAL_PROGRESS = 0;
  private final static int MIN_PROGRESS = 0;
  private final static int MAX_PROGRESS = 100;
  private final static String ADD_BTN_LABEL = "Add task";
  private final static String CLOCK_IN_BTN_LABEL = "Clock in";
}
