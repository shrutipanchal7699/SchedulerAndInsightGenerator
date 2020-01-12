import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame{
  public View(Model model){
    this.model = model;
    navigationPanel = new NavigationPanel();
    schedulerPanel = new SchedulerPanel(this);
    journalPanel = new JournalPanel(this);
    howToPanel = new HowToPanel();
    aboutPanel = new AboutPanel();


    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationPanel, schedulerPanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(200);

		add(splitPane);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }

  public Model getModel(){
    return model;
  }

  public void update(){
    schedulerPanel.getLeftPanel().refresh();
    journalPanel.getLeftPanel().refresh();
    schedulerPanel.getRightPanel().getGraphPanel().refresh();
    journalPanel.getRightPanel().getGraphPanel().refresh();
  }

  /**
  * Attaches an action listener to the add button in the scheduler panel
  * @param e the action listener to be attached
  */
  public void addSchedulerPanelAddBtnListener(ActionListener e){
    schedulerPanel.getRightPanel().getButtonPanel().getAddBtn().addActionListener(e);
  }

  /**
   * Attaches an action listener to the clock in button in the scheduler panel
   * @param e the action listener to be attached
  */
  public void addSchedulerPanelCloclInBtnListener(ActionListener e){
    schedulerPanel.getRightPanel().getButtonPanel().getClockInBtn().addActionListener(e);
  }

  /**
   * Attaches an action listener to the add activity button in the journal panel
   * @param e the action listener to be attached
  */
  public void addJournalPanelAddActivityBtnListener(ActionListener e){
    journalPanel.getRightPanel().getButtonPanel().getAddBtn().addActionListener(e);
  }

  public void addJournalPanelAddNoteBtnListener(ActionListener e){
    journalPanel.getRightPanel().getButtonPanel().getNoteBtn().addActionListener(e);
  }

  /**
   * Returns the journal panel
   * @return journalPanel
  */
  public JournalPanel getJournalPanel(){
    return journalPanel;
  }

  private Model model;
  private JPanel navigationPanel;
	private JPanel howToPanel;
	private SchedulerPanel schedulerPanel;
	private JournalPanel journalPanel;
	private JPanel aboutPanel;
	private JSplitPane splitPane;

  private class NavigationPanel extends JPanel{
    public NavigationPanel(){
      setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
      setVisible(true);

      howToBtn = new JButton(HOW_TO_BTN_LABEL);
      schedulerBtn = new JButton(SCHEDULER_BTN_LABEL);
      journalBtn = new JButton(JOURNAL_BTN_LABEL);
      aboutBtn = new JButton(ABOUT_BTN_LABEL);

      howToBtn.addActionListener(new
        ActionListener(){
          public void actionPerformed(ActionEvent event){
            splitPane.setRightComponent(howToPanel);
          }
        });
      schedulerBtn.addActionListener(new
        ActionListener(){
          public void actionPerformed(ActionEvent event){
            splitPane.setRightComponent(schedulerPanel);
          }
        });
      journalBtn.addActionListener(new
        ActionListener(){
          public void actionPerformed(ActionEvent event){
            splitPane.setRightComponent(journalPanel);
          }
        });
      aboutBtn.addActionListener(new
        ActionListener(){
          public void actionPerformed(ActionEvent event){
            splitPane.setRightComponent(aboutPanel);
          }
        });


      add(howToBtn);
      add(schedulerBtn);
      add(journalBtn);
      add(aboutBtn);
    }

    private JButton howToBtn;
    private JButton schedulerBtn;
    private JButton journalBtn;
    private JButton aboutBtn;

    public static final String HOW_TO_BTN_LABEL = "How to";
    public static final String SCHEDULER_BTN_LABEL = "Scheduler";
    public static final String JOURNAL_BTN_LABEL = "Journal";
    public static final String ABOUT_BTN_LABEL = "About";

    public static final int NUM_ROWS = 4;
    public static final int NUM_COLS = 1;
  }
}
