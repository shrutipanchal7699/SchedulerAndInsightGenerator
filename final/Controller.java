import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Models the controller for the application
 * @author Akshat Bansal
*/
public class Controller{
  /**
   * Constructs an instance of a controller for the given model and view
   * @param model data model of the application
   * @param view view of the application
  */
  public Controller(Model model, View view){
    this.model = model;
    this.view = view;

    this.view.addSchedulerPanelAddBtnListener(new SchedulerPanelAddBtnListener());
    this.view.addSchedulerPanelCloclInBtnListener(new SchedulerPanelClockInBtnListener());
    this.view.addJournalPanelAddActivityBtnListener(new JournalPanelAddBtnListener());
    this.view.addJournalPanelAddNoteBtnListener(new JournalPanelNoteBtnListener());
  }

  /**
   * Inner class represents the action when user clicks the add button in the scheduler panel
   * 1) Show the task input panel
   * 2) Construct a task from the provided input
   * 3) Add the new task to the unfinished set
   * 4) Commit changes to database
   * 5) Reload data structures from database
   * 6) Update the UI components - graph, progress bar, list panels etc
  */
  class SchedulerPanelAddBtnListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int userChoice = JOptionPane.showConfirmDialog(null, TASK_INPUT_PANEL, TASK_INPUT_PANEL_LABEL, JOptionPane.OK_CANCEL_OPTION);

      if (userChoice == JOptionPane.OK_OPTION){
        Task task = new Task(TASK_INPUT_PANEL.getName(), TASK_INPUT_PANEL.getCategory(), 0, TASK_INPUT_PANEL.getNumHrs(),
                              TASK_INPUT_PANEL.getPriority(), TASK_INPUT_PANEL.getDeadline(), TASK_INPUT_PANEL.getNote());

        if (model.addNewUnfinishedTask(task))
          System.out.println("Task added successfully");
        else
          System.out.println("Task already exists. Increasing hours left");

        model.commitChanges();
        model.loadFromDatabase();
        view.update();
      }
    }
  }

  /**
   * Inner class represents the action when user clicks the clock in button in the scheduler panel
   * 1) Show the activity input panel
   * 2) Get the name of the selected task
   * 3) Find that task in the unfinished set
   * 4) Get the number of hours entered by the user
   * 5) Invest that amount of hours in the task found in 3
   * 6) Commit changes to database
   * 7) Reload data structures from database
   * 8) Update the UI components - progress bars both individual and the overall
  */
  class SchedulerPanelClockInBtnListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String[] taskChoices = new String[model.getUnfinishedTasks().size()];
      ArrayList<Task> taskList = new ArrayList<>(model.getUnfinishedTasks());
      for (int i = 0; i < taskList.size(); i++) taskChoices[i] = taskList.get(i).getName();
      RegisterTaskInputPanel registerInputPanel = new RegisterTaskInputPanel(taskChoices);


      int userChoice = JOptionPane.showConfirmDialog(null, registerInputPanel, REGISTER_INPUT_PANEL_LABEL, JOptionPane.OK_CANCEL_OPTION);
      if (userChoice == JOptionPane.OK_OPTION){
        String selectedTaskName = registerInputPanel.getName();
        Set<Task> unfinishedTasks = model.getUnfinishedTasks();

        for (Task t: unfinishedTasks){
          if (t.getName().equals(selectedTaskName)){
            t.investHrs(registerInputPanel.getNumHrs());
            break;
          }
        }

        model.commitChanges();
        model.loadFromDatabase();
        view.update();
      }
    }
  }

  /**
   * Inner class represents the action when user clicks on the add activity button in the journal panel
   * 1) Show the RegisterActivityPanel
   * 2) Construct an activity from the provided input
   * 3) Add the new task to the activities list
   * 4) Commit changes to database
   * 5) Reload data structures from database
   * 6) Update the UI components - graph, progress bar, list panels etc
  */
  class JournalPanelAddBtnListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int userChoice = JOptionPane.showConfirmDialog(null, ACTIVITY_INPUT_PANEL, ACTIVITY_INPUT_PANEL_LABEL, JOptionPane.OK_CANCEL_OPTION);
      if (userChoice == JOptionPane.OK_OPTION){
        Activity activity = new Activity(ACTIVITY_INPUT_PANEL.getName(), ACTIVITY_INPUT_PANEL.getCategory(),
                                ACTIVITY_INPUT_PANEL.getNumHrs(), ACTIVITY_INPUT_PANEL.getNote());

        model.addActivity(activity);
        model.commitChanges();
        model.loadFromDatabase();
        view.update();
      }
    }
  }

  class JournalPanelNoteBtnListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String note = JOptionPane.showInputDialog("Write note");
      view.getJournalPanel().getLeftPanel().getBottomPanel().addStickyNote(note);
    }
  }


  private Model model;
  private View view;

  private final static String TASK_INPUT_PANEL_LABEL = "Please fill out the details of the task";
  private final static String REGISTER_INPUT_PANEL_LABEL  = "Please indicate the task you worked on";
  private final static String ACTIVITY_INPUT_PANEL_LABEL = "Please fill out the details of the activity";
  private final static String[] CATEGORY_CHOICES = {"Work", "Study", "Routine"};
	private final static String[] PRIORITY_CHOICES = {"Urgent", "Very high", "High", "Medium", "Low"};
  private final static String[] ACTIVITY_CATEGORIES  = {"Sport", "Video game", "Social Media", "Travel", "Netflix", "Sleep"};
  private final static TaskInputPanel TASK_INPUT_PANEL = new TaskInputPanel(PRIORITY_CHOICES, CATEGORY_CHOICES);
  private final static ActivityInputPanel ACTIVITY_INPUT_PANEL = new ActivityInputPanel(ACTIVITY_CATEGORIES);
}
