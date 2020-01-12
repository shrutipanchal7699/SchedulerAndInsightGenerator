import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Models the panel with the add activity and add note buttons
*/
public class JournalButtonPanel extends JPanel{
	/**
	 * Constructs an instance of the JournalButtonPanel
	 * @param parentView the parent view of the Journal panel
	*/
	public JournalButtonPanel(View parentView){
		this.parentView = parentView;
		addBtn = new JButton(ADD_BTN_LABEL);
	  noteBtn = new JButton(NOTE_BTN_LABEL);
	  activityInputPanel = new ActivityInputPanel(categoryChoices);

	  setLayout(new GridLayout(3,1));
	  add(addBtn);
	  add(noteBtn);

	  setVisible(true);
	  setBackground(Color.DARK_GRAY);
	}

	/**
	 * Returns the add button on the jounal panel
	 * @return addBtn
	*/
	public JButton getAddBtn(){
		return addBtn;
	}

	/**
	 * Returns the note button on the jounral panel
	 * @return noteBtn
	*/
	public JButton getNoteBtn(){
		return noteBtn;
	}

	private JButton addBtn;
  private JButton noteBtn;
	private ActivityInputPanel activityInputPanel;
	private View parentView;

  private static final String[] categoryChoices = {"Sport", "Video game", "Social Media", "Travel", "Netflix", "Sleep"};
	private static final String ADD_BTN_LABEL = "Add Activity";
	private static final String NOTE_BTN_LABEL = "Add Sticky Note";
}
