import java.awt.*;
import javax.swing.*;

/**
 * Models a container for activity name
 * @author Akshat Bansal
*/
public class TaskNamePanel extends JPanel{
	/**
	 * Constructs an instance of the activity name panel
	 * @param activityName name of the activity
	*/
	public TaskNamePanel(View parentView, Task task){
		this.task = task;
		this.parentView = parentView;

		setLayout(new GridLayout(PANEL_NUM_ROWS, PANEL_NUM_COLS));
		setBackground(new Color(74, 74, 74));

		taskProgressBar = new JProgressBar(0, 100);
		taskProgressBar.setStringPainted(true);
		taskProgressBar.setString(task.getName());
		Color color = new Color(50, 168, 82);
		taskProgressBar.setStringPainted(true);

		taskProgressBar.setValue(task.getHrsSpent()/(task.getHrsLeft() + task.getHrsSpent()));
		add(taskProgressBar);
		setVisible(true);
	}

	public void refresh(){
		taskProgressBar.setValue(task.getHrsSpent()/(task.getHrsLeft() + task.getHrsSpent()));
		revalidate();
		repaint();
	}


	public String getTaskName(){
		return task.getName();
	}


	private JProgressBar taskProgressBar;
	private Task task;
	private View parentView;
	public final static int PANEL_NUM_ROWS = 1;
	public final static int PANEL_NUM_COLS = 1;
}
