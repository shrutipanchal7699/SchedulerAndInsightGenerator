import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the input panel that pops up when user clicks the add activity button
 * @author Akshat Bansal
*/
public class ActivityInputPanel extends JPanel{
  /**
   * Constructs an instance of the ActivityInputPanel
   * @param categoryChoices activity categories
  */
  public ActivityInputPanel(String[] categoryChoices){
    setLayout(new GridLayout(INPUT_PANEL_NUM_ROWS, INPUT_PANEL_NUM_COLS));

    nameTF            = new JTextField("Enter name");
    categoryDropDown  = new JComboBox<>(categoryChoices);
    numHrsTF          = new JTextField("Enter number of hours");
    noteTF            = new JTextField("[OPTIONAL] Add note");

    add(nameTF);
    add(categoryDropDown);
    add(numHrsTF);
    add(noteTF);

    setVisible(true);
  }


  /**
   * Returns the name of the activity
   * @return name of the activity
  */
  public String getName(){
    return nameTF.getText();
  }

  /**
   * Returns the category of the activity
   * @return category of the activity
  */
  public String getCategory(){
    return (String)categoryDropDown.getSelectedItem();
  }

  /**
   * Returns the number of hours
   * @return the number of hours
  */
  public int getNumHrs(){
    return Integer.parseInt(numHrsTF.getText());
  }

  /**
   * Returns the note associated with the activity
   * @return the note associated with the activity
  */
  public String getNote(){
    return noteTF.getText();
  }

  public void setNameTF(String nameText)
  {
    nameTF.setText(nameText);
  }

  public void setnumHrsTF(int hrs)
  {
    numHrsTF.setText(""+hrs);
  }

  public void setNoteTF(String noteText)
  {
    noteTF.setText(noteText);
  }


  private final static int INPUT_PANEL_NUM_ROWS = 4;
  private final static int INPUT_PANEL_NUM_COLS = 1;

  private JTextField nameTF;
  private JComboBox<String> categoryDropDown;
  private JTextField numHrsTF;
  private JTextField noteTF;
}
