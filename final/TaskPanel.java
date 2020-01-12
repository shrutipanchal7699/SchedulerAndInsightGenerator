import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models an individual container for the task name panel and the associated CRUD options panels
 * @author Akshat Bansal
*/
public class TaskPanel extends JPanel{
	/**
	 * Constructs an instance of the activityPanel with the given activity name.
	 * @param activityName name of the activity
	*/
	public TaskPanel(View parentView, Task task){
		this.parentView = parentView;
		taskNamePanel = new TaskNamePanel(parentView, task);
		taskOptionsPanel = new TaskOptionsPanel(parentView);
		setBackground(new Color(204, 226, 227));

		taskOptionsPanel.setTaskPanel(this);
		taskOptionsPanel.setListPanel(parentListPanel);

		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = ACTIVITY_NAME_PANEL_WIDTH_RATIO;
		c.weighty = ACTIVITY_NAME_PANEL_HEIGHT_RATIO;
		add(taskNamePanel, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = OPTIONS_PANEL_WIDTH_RATIO;
		c.weighty = OPTIONS_PANEL_HEIGHT_RATIO;
		add(taskOptionsPanel, c);

		setVisible(true);
	}

	public void refresh(){
		taskNamePanel.refresh();
		revalidate();
		repaint();
	}

	/**
	 * Returns the activity name panel contained by this activity panel
	 * @return activityNamePanel the activity name panel contained by this activity panel
	*/
	public TaskNamePanel getTaskNamePanel(){
		return taskNamePanel;
	}

	/**
	 * Returns the list panel which contains this activity panel
	 * @return parentListPanel the list panel which contains this activity panel
	*/
	public JPanel getParentListPanel(){
		return parentListPanel;
	}

	/**
	 * Sets the parent list panel instance variable equal to the argument
	 * @param parentListPanel
	*/
	public void setParentListPanel(TaskListPanel parentListPanel){
		this.parentListPanel = parentListPanel;
	}

	public final static double ACTIVITY_NAME_PANEL_WIDTH_RATIO = 0.7;
	public final static double OPTIONS_PANEL_WIDTH_RATIO = 0.3;
	public final static double ACTIVITY_NAME_PANEL_HEIGHT_RATIO = 1;
	public final static double OPTIONS_PANEL_HEIGHT_RATIO = 1;

	private TaskNamePanel taskNamePanel;
	private TaskOptionsPanel taskOptionsPanel;
	private TaskListPanel parentListPanel;
	private View parentView;
	private Task task;
}
