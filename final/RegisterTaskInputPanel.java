import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models the input panel that pops up when user clicks the add activity button
 * @author Akshat Bansal
*/
public class RegisterTaskInputPanel extends JPanel {
  /**
   * Constructs an instance of the RegisterTaskInputPanel
   * @param categoryChoices activity categories
  */
  public RegisterTaskInputPanel(String[] categoryChoices){
    tasksDropDown  = new JComboBox<>(categoryChoices);
    numHrsTF       = new JTextField(TEXT_FIELD_LABEL);

    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(tasksDropDown);
    add(numHrsTF);
    setVisible(true);
  }

  /**
   * Returns the category of the activity
   * @return category of the activity
  */
  public String getName(){
    return (String)tasksDropDown.getSelectedItem();
  }

  /**
   * Returns the number of hours
   * @return the number of hours
  */
  public int getNumHrs(){
    return Integer.parseInt(numHrsTF.getText());
  }

  private JComboBox<String> tasksDropDown;
  private JTextField numHrsTF;

  private final static int NUM_ROWS = 4;
  private final static int NUM_COLS = 1;
  private final static String TEXT_FIELD_LABEL = "Enter #hrs worked";


  /**
   * Tester for activity input panel
  */
  public static void main(String[] args){
    JFrame app = new JFrame("Tester for RegisterTaskInputPanel ");
    String[] choices = {"Task1", "Task2", "Task3", "Task4"};
    RegisterTaskInputPanel RegisterTaskInputPanel= new RegisterTaskInputPanel (choices);
    JButton addBtn = new JButton("Register Hours ");

    addBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null, RegisterTaskInputPanel
        , "Please activity details", JOptionPane.OK_CANCEL_OPTION);

        System.out.println("Tasks: " + RegisterTaskInputPanel
        .getName());
        System.out.println("#Hours: " + RegisterTaskInputPanel
        .getNumHrs());

      }
    });
    app.add(addBtn);

    app.setLayout(new FlowLayout());
    app.pack();
    app.setVisible(true);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
