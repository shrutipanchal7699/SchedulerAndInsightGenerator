import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


/**
 * Models a top-level container for individual activity panels
 * @author Akshat Bansal
*/
public class ActivityListPanel extends JPanel{
	/**
	 * Constructs an instance of the ListPanel
	*/
	public ActivityListPanel(View parentView, String label){
		this.parentView = parentView;
		header = new JLabel(label);
		activityPanels = new ArrayList<>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		//vertical arrangement of activity panels
		add(header);
		setBackground(new Color(204, 226, 227));
		setVisible(true);

		refresh();
	}

	public void refresh(){
		load();
		for (ActivityPanel activityPanel: activityPanels)
			activityPanel.refresh();

		revalidate();
		repaint();
	}

	public void load(){
		removeAll();
		activityPanels.clear();
		repaint();
		revalidate();
		add(header);

		ArrayList<Activity> activities = parentView.getModel().getActivities();

		for (Activity act: activities){
			ActivityPanel activityPanel = new ActivityPanel(parentView, act);
			activityPanels.add(activityPanel);
			add(activityPanel);
		}

		revalidate();
		repaint();
	}

	private View parentView;
	private JLabel header;
	private final ArrayList<ActivityPanel> activityPanels;
}
