import java.awt.*;
import javax.swing.*;

/**
 * Models a container for activity name
 * @author Akshat Bansal
*/
public class ActivityNamePanel extends JPanel{
	/**
	 * Constructs an instance of the activity name panel
	 * @param activityName name of the activity
	*/
	public ActivityNamePanel(View parentView, Activity activity){
		this.activity = activity;
		this.parentView = parentView;

		progressBar = new JProgressBar(0, 100);
		progressBar.setString(activity.getName());
		progressBar.setStringPainted(true);

		setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
		setBackground(new Color(74, 74, 74));
		add(progressBar);
		setVisible(true);
	}

	public void refresh(){
		revalidate();
		repaint();
	}

	public String getActivityName(){
		return activity.getName();
	}

	private JProgressBar progressBar;
	private Activity activity;
	private View parentView;
	public final static int NUM_ROWS = 1;
	public final static int NUM_COLS = 1;
}
