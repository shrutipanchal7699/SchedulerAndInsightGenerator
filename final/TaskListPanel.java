import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


/**
 * Models a top-level container for individual task panels
 * @author Akshat Bansal
*/
public class TaskListPanel extends JPanel{
	/**
	 * Constructs an instance of the TaskListPanel
	*/
	public TaskListPanel(View parentView, int dayNum, String label){
		this.parentView = parentView;
		this.dayNum = dayNum;
		header = new JLabel(label);
		taskPanels = new ArrayList<>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(header);
		setBackground(new Color(204, 226, 227));
		setVisible(true);

		load();
	}

	public void refresh(){
		load();
		for (TaskPanel taskPanel: taskPanels)
			taskPanel.refresh();

		revalidate();
		repaint();
	}

	public void load(){
		removeAll();
		taskPanels.clear();
		repaint();
		revalidate();
		add(header);

		Set<Task> unfinished  = parentView.getModel().getWeeklySchedule().get(dayNum);

		for (Task t: unfinished){
			TaskPanel taskPanel = new TaskPanel(parentView, t);
			taskPanels.add(taskPanel);
			add(taskPanel);
		}
		revalidate();
		repaint();
	}

	private View parentView;
	private JLabel header;
	private int dayNum;
	private final ArrayList<TaskPanel> taskPanels;
}
