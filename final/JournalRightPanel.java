import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class JournalRightPanel extends JPanel {

	public JournalRightPanel(View parentView) {
		this.parentView = parentView;
		graphPanel = new JournalBarGraph(this.parentView, GRAPH_TITLE);
		journalButtonPanel = new JournalButtonPanel(this.parentView);

		graphPanel.setBackground(new Color(131, 133, 126));

		setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
		add(graphPanel);
		add(journalButtonPanel);
		setVisible(true);
	}


	/**
	 * Returns the button panel of the journal panel
	 * @return journalButtonPanel
	*/
	public JournalButtonPanel getButtonPanel(){
		return journalButtonPanel;
	}

	/**
	 * Returns the graph panel of the journal panel
	 * @return graphPanel
	*/
	public JournalBarGraph getGraphPanel(){
		return graphPanel;
	}

	private JournalBarGraph graphPanel;
	private JournalButtonPanel journalButtonPanel;
	private View parentView;

	private static final String GRAPH_TITLE = "Time spent on hobbies";
	private static final int NUM_ROWS = 2;
	private static final int NUM_COLS = 1;
}
