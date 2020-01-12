import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Date;
import java.util.Calendar;
import java.util.*;

public class SchedulerBarGraph extends JPanel {
  public SchedulerBarGraph(View parentView, String title) {
    this.parentView = parentView;
    this.title = title;
    this.numDayWorkWeek = this.parentView.getModel().getNumDayWorkWeek();
    this.dailyWorkload = this.parentView.getModel().getDailyWorkload();
    this.labels = new String[this.numDayWorkWeek];
    this.values = new double[this.numDayWorkWeek];



    resetLabels();
    /**
     * Generate values for the graph according to the schedule
    */
    ArrayList<Task> unfinishedTasks = new ArrayList<>(this.parentView.getModel().getUnfinishedTasks());
    int taskNdx = 0;
    //for each working day
    for (int i = 0; taskNdx < unfinishedTasks.size() && i < numDayWorkWeek; i++){
      //for each task for that day
      int workload = 0;
      for (int j = 0; taskNdx < unfinishedTasks.size() && j + unfinishedTasks.get(taskNdx).getHrsLeft()<= dailyWorkload; j++){
        j += unfinishedTasks.get(taskNdx).getHrsLeft();
        taskNdx++;
        workload = j;
      }
      this.values[i] = workload;
    }

    for (int i = 0; i < labels.length; i++)
      labels[i] += " - " + (int)values[i] + " hrs";
  }

  public void resetLabels(){
    /**
     * Generate labels according to current day
     * 0 -> Mon, 1 -> Tue, 2 -> Wed, 3 -> Thu, 4 -> Fri
    */
    ArrayList<Activity> activities = parentView.getModel().getActivities();

    for (int i = 0; i < activities.size(); i++){
      labels[i]= activities.get(i).getName();
    }
  }

  public void refresh(){
    /**
     * Generate values for the graph according to the schedule
    */
    resetLabels();
    ArrayList<Task> unfinishedTasks = new ArrayList<>(this.parentView.getModel().getUnfinishedTasks());
    int taskNdx = 0;
    //for each working day
    for (int i = 0; taskNdx < unfinishedTasks.size() && i < numDayWorkWeek; i++){
      //for each task for that day
      int workload = 0;
      for (int j = 0; taskNdx < unfinishedTasks.size() && j + unfinishedTasks.get(taskNdx).getHrsLeft()<= dailyWorkload; j++){
        j += unfinishedTasks.get(taskNdx).getHrsLeft();
        taskNdx++;
        workload = j;
      }
      this.values[i] = workload;
    }

    for (int i = 0; i < labels.length; i++)
      labels[i] += " - " + (int)values[i] + " hrs";

    revalidate();
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }

    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i]) {
        minValue = values[i];
      }
      if (maxValue < values[i]) {
        maxValue = values[i];
      }
    }

    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;

    Font titleFont = new Font("Book Antiqua", Font.BOLD, 40);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);

    Font labelFont = new Font("Book Antiqua", Font.BOLD, 16);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);

    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maxValue - minValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maxValue - values[j]) * scale);
      } else {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      //g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);

      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
    }
  }

  private double[] values;
  private String[] labels;
  private String title;
  private View parentView;
  private int dailyWorkload;
  private int numDayWorkWeek;

  private static final Color[] colors = {new Color(255, 135, 135), new Color(89, 186, 255),
                                          new Color(154, 145, 255), new Color(255, 179, 247),
                                          new Color(255, 153, 94), new Color(255, 25, 135),
                                          new Color(5, 135, 135)};
  private static final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

  public static void main(String[] args){
    Model m = new Model();
    Task task1 = new Task("CS 151 Project", "Work", 0, 2, "Very High", "Today", "");
    Task task2 = new Task("CS 157 Study", "Study", 0, 3, "Urgent", "Saturday", "");
    m.addNewUnfinishedTask(task1);
    m.addNewUnfinishedTask(task2);

    m.commitChanges();

    View v = new View(m);
    v.setVisible(true);
    v.pack();
    v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
