import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class HowToPanel extends JPanel{
/*	public HowToPanel(){
		textArea = new JTextArea("How to text here", 150, 200);
		setLayout(new GridLayout(1,1));
		add(textArea);
		setVisible(true);
		setPreferredSize(new Dimension(100, 200));
	}
	public static void main(String[] args){
		JPanel howToPanel = new HowToP
		anel();
		JFrame app = new JFrame();
		app.add(howToPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}
	*/

	public HowToPanel()
	{
		//Container c = getContentPane( );
		Color color = new Color(204, 226, 227);
		setLayout(new GridLayout( 2, 2)); 			 // a text of mixed colors
		String text1 = "<html><font size = 4>"+
						"It is not uncommon to see that we do not use our time to get the optimal output and unfortunately this becomes crucial to surviving a student or company life. We recognized this as a problem since the boom in social media and applications become an easy way out. They further cause inefficiency and lack of productivity in our work sessions.<p> We believe that our app is an innovative way to solve this problem. The prioritizing algorithm and user-friendly design will certainly help to encourage a good routine and schedule your hours."+
						"</font></html>";
		JLabel label1 = new JLabel();
		label1.setText(text1);
		label1.setIcon(new ImageIcon("./images/matrix.JPEG"));
		label1.setBorder(BorderFactory.createTitledBorder("<html><font size = 5>Inspiration for the App</font></html>"));
		label1.setBackground(color);

		add(label1);

		String text2 = "<html><font size = 4>"+
						"How To : "+
						"<ul>"+"<li>Add a task: Click on the Add Task button and enter the details asked.</li>"+
						"<li>Clock In: FInd the task that you have worked on in the drop-down menu and then enter the number of hours you spent on it.</li>"+
						"</ul>"+
						"Understanding:"+
						"<ul>"+
						"<li> Progress Bar: The bar above the add task button shows you your overall progress accounting for the time you have spent on the tasks and how much more you need to spend</li>"+
						"<li> Graph: We show the current day first and then you can look at a summarized version of how many hours you need to spend on your tasks that week.</li>"+
						"<li>Task List: Both the lists can be edited using the three buttons given on each task. The first button deletes a task, the second edits it, and the third symbolizes the completion of a task.</li>"+
					//	"<li>kjashfkjahfuoadhfouehfweunkjvnsknv</li>"+
					//	"<li>kjashfkjahfuoadhfouehfweunkjvnsknv</li>"+
					//	"<li>kjashfkjahfuoadhfouehfweunkjvnsknv</li>"+
					//	"<li>kjashfkjahfuoadhfouehfweunkjvnsknv</li>"+
					//	"<li>kjashfkjahfuoadhfouehfweunkjvnsknv</li>"+
						"</ul></font></html>";
		JLabel label2 = new JLabel(text2);
		//label2.setText(text2);
		label2.setBorder(BorderFactory.createTitledBorder("<html><font size = 5>Scheduler's Working</font></html>"));
		label2.setBackground(color);
		//JScrollPane scroller = new JScrollPane(label2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//js.setPreferredSize(new Dimension(200,200));

   		//JOptionPane.showMessageDialog(null, js);
		add(label2);


		String text3 = "<html><font size = 4>"+
						"How To : "+
						"<ul>"+
						"<li>Add an Activity: Click on the Add Activity button and enter the details asked.</li>"+
						"<li>Add a Reminder: Click on the Add Reminder button and enter the details. You can edit it any time</li>"+
						"</ul>"+
						"Understanding: "+
						"<ul>"+
						"<li>Graph: We show the current day first and then you can look at a summarized version of how many hours you need to spend on your tasks that week.</li>"+
						"<li>ActivityList: Both the lists can be edited using the three buttons given on each task. The first button deletes a task, the second edits it, and the third symbolizes the completion of a task.</li>"+
						"</ul></font></html>";


		JLabel label3 = new JLabel(text3);
		label3.setBorder(BorderFactory.createTitledBorder("<html><font size = 5>Journal's Working</font></html>"));
		label3.setBackground(color);
		add(label3);

		String text4 ="<html><font size = 4>"+
						"Basic Logic:  "+
						"<ul>"+
						"<li>The underlying algorithm sorts the tasks based on their priority and the day they are due using compareTo method for a treeset.</li>"+
						"<li> Based on the priority that you have selected for a particular task, we assign an integer value to it </li>"+
						"<ul>"+"(Urgent = 0, Very high = 1, High = 2, Medium = 3, Low = 5)"+"<p>"+"<p>"+
						"<font align = center size = 3.2>"+
						"VALUE = (0.8 X PRIORITY) + (0.2 X DAYS LEFT)"	+ "</font>"+ "</ul>"+
						"<li>Then based on the above equation, we calculate a double value for the task.</li>"+

						"<li>As these tasks are added into a treeset, the compareTo method compares all the sorting values of every task with each other and sorts the tasks accordingly from lowest to highest value.</li>"+
						"<li> We decided to give a higher value to the importance of a task as it is necessary to finish the important tasks on their deadline as tasks with lower importance do not warrant as much attention. </li>"+
						"</ul></font></html>";

		JLabel label4 = new JLabel(text4);

		JLabel pic = new JLabel(new ImageIcon("./images/matrix.JPEG"), SwingConstants.CENTER);

		label4.setBorder(BorderFactory.createTitledBorder("<html><font size = 5>Scheduling Algorithm</font></html>"));
		label4.setBackground(color);
		add(label4);
		//add(pic);



		JScrollPane js = new JScrollPane();


		setSize(500,600);
   		setVisible(true);
	}

	public static void main(String args[])
	{

		HowToPanel h = new HowToPanel();
		JScrollPane js = new JScrollPane(h,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}


	private JTextArea textArea;


}
