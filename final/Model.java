import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Models a data model for the planner application
 * @author Akshat Bansal
*/
public class Model{
  /**
   * Constructs an instance of the model
  */
  public Model(){
    try{
      File file = new File("./config.ini");
      boolean firstRun = file.createNewFile();

      //If this is the first run for the application
      if (firstRun){
        //Ask user the amount of hours he wants to work per day
        dailyWorkload = Integer.parseInt(JOptionPane.showInputDialog("Enter number of hours you want to work per day"));
        numDayWorkWeek = Integer.parseInt(JOptionPane.showInputDialog("Enter number of days you want to work per week"));

        //Allocate memory for data structures
        unfinished = new TreeSet<>();
        finished = new ArrayList<>();
        activities = new ArrayList<>();

        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(dailyWorkload);
        pw.println(numDayWorkWeek);
        pw.close();
        fw.close();

        weeklySchedule = new ArrayList<>(numDayWorkWeek);
        for (int i = 0; i < numDayWorkWeek; i++)
          weeklySchedule.add(new TreeSet<Task>());
      }
      //Else if this is not the first run of the application
      else{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        dailyWorkload = Integer.parseInt(br.readLine());
        numDayWorkWeek = Integer.parseInt(br.readLine());
        br.close();
        fr.close();

        weeklySchedule = new ArrayList<>(numDayWorkWeek);
        for (int i = 0; i < numDayWorkWeek; i++)
          weeklySchedule.add(new TreeSet<Task>());
        loadFromDatabase();
      }

    }
    catch (Exception e){
      System.out.println("Stress is constructor: " + e.getMessage());
    }
  }

  /**
   * Adds a task to the unfinished set if it isnt already there
   * If the task already exists, then it increments the number of hrs
   * @param task new task to be added
   * @return true if the task has been added successfully, faLse if the task was already in the set
  */
  public boolean addNewUnfinishedTask(Task task){
    if (!unfinished.add(task)){
      Task t = task;

      //Find the task in the set that is equal to the task in the argument
      for (Task tsk: unfinished){
        if (tsk.equals(task)){
          t = tsk;
          break;
        }
      }

      //Increment the hours required for that task
      t.incrementHrsReqd(task.getHrsLeft());
      return false;
    }
    return true;
  }

  /**
   * Adds a task to the finished list
   * @param task new task to be added
   * @return true
  */
  public boolean addNewFinishedTask(Task task){
    return finished.add(task);
  }

  /**
   * Adds an activity to the activities list
   * @param act new activity to be added
   * @return true
  */
  public boolean addActivity(Activity act){
    return activities.add(act);
  }


  /**
   * Laods database into data structures
  */
  public void loadFromDatabase(){
    /**
     * Open the file streams to the three files
     * Recover the state of data structures
     * Close the file streams
    */

    try{
      //Recover the state of unfinished set from unfinished.dat
      unfinishedFileInputStream = new FileInputStream(UNFINISHED_FILE_PATH);
      unfinishedSetInputStream = new ObjectInputStream(unfinishedFileInputStream);
      unfinished = (Set<Task>)unfinishedSetInputStream.readObject();
      unfinishedSetInputStream.close();
      unfinishedFileInputStream.close();

      //Recover the state of finished list from finished.dat
      finishedFileInputStream = new FileInputStream(FINISHED_FILE_PATH);
      finishedListInputStream = new ObjectInputStream(finishedFileInputStream);
      finished = (ArrayList<Task>)finishedListInputStream.readObject();
      finishedListInputStream.close();
      finishedFileInputStream.close();

      //Recover the state of activities list from activities.dat
      activitiesFileInputStream = new FileInputStream(ACTIVITIES_FILE_PATH);
      activitiesListInputStream = new ObjectInputStream(activitiesFileInputStream);
      activities = (ArrayList<Activity>)activitiesListInputStream.readObject();
      activitiesListInputStream.close();
      activitiesFileInputStream.close();

      generateWeeklySchedule();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  /**
   * Commits changes in data structures to database
  */
  public void commitChanges(){
    try{
      //Record the state of unfinished set in unfinished.dat
      unfinishedFileOutputStream = new FileOutputStream(UNFINISHED_FILE_PATH);
      unfinishedSetOutputStream = new ObjectOutputStream(unfinishedFileOutputStream);
      unfinishedSetOutputStream.writeObject(unfinished);
      unfinishedSetOutputStream.close();
      unfinishedFileOutputStream.close();

      //Record the state of finished list in finished.dat
      finishedFileOutputStream = new FileOutputStream(FINISHED_FILE_PATH);
      finishedListOutputStream = new ObjectOutputStream(finishedFileOutputStream);
      finishedListOutputStream.writeObject(finished);
      finishedListOutputStream.close();
      finishedFileOutputStream.close();

      //Record the state of activities list in activities.dat
      activitiesFileOutputStream = new FileOutputStream(ACTIVITIES_FILE_PATH);
      activitiesListOutputStream = new ObjectOutputStream(activitiesFileOutputStream);
      activitiesListOutputStream.writeObject(activities);
      activitiesListOutputStream.close();
      activitiesFileOutputStream.close();
    }
    catch(Exception e){
      System.out.println("Stress in commiting changes: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * construct schedule at runtime.
   * current version --> The amount of time required for any task should not be
   * greater than the amount of work user wants to work in a day.
  */
  public void generateWeeklySchedule(){
    for (int i = 0; i < numDayWorkWeek; i++)
      weeklySchedule.get(i).clear();

    int day = 0;
    int workHrs = 0;

    for (Task unfinishedTask: unfinished){
      if (day > numDayWorkWeek - 1) break;

      //if there is room for this task --> add it. Else, move to the next day
      if (workHrs + unfinishedTask.getHrsLeft() <= dailyWorkload){
        weeklySchedule.get(day).add(unfinishedTask);
        workHrs += unfinishedTask.getHrsLeft();
      }
      else{
        day++;
        weeklySchedule.get(day).add(unfinishedTask);
        workHrs = unfinishedTask.getHrsLeft();
      }
    }
  }

  /**
   * Returns the amount of hrs user wants to work per
   * @return dailyWorkload
  */
  public int getDailyWorkload(){
    return dailyWorkload;
  }

  /**
   * Gets the number of days the user wants to work in a week
   * @return numDayWorkWeek
  */
  public int getNumDayWorkWeek(){
    return numDayWorkWeek;
  }

  /**
   * Returns the unfinished task set
   * @return the unfinished task set
  */
  public Set<Task> getUnfinishedTasks(){
    return unfinished;
  }

  /**
   * Returns the finished task list
   * @return the finished task list
  */
  public ArrayList<Task> getFinishedTasks(){
    return finished;
  }

  /**
   * Returns the activities list
   * @return the activities list
  */
  public ArrayList<Activity> getActivities(){
    return activities;
  }

  /**
   * Returns the weekly schedule
   * @return weeklySchedule
  */
  public ArrayList<TreeSet<Task>> getWeeklySchedule(){
    return weeklySchedule;
  }

  private Set<Task> unfinished;
  private ArrayList<Task> finished;
  private ArrayList<Activity> activities;
  private ArrayList<TreeSet<Task>> weeklySchedule;
  private int dailyWorkload;
  private int numDayWorkWeek;

  private FileOutputStream unfinishedFileOutputStream;
  private FileOutputStream finishedFileOutputStream;
  private FileOutputStream activitiesFileOutputStream;
  private FileOutputStream scheduleFileOutputStream;
  private FileInputStream unfinishedFileInputStream;
  private FileInputStream finishedFileInputStream;
  private FileInputStream activitiesFileInputStream;
  private FileInputStream scheduleFileInputStream;

  private ObjectOutputStream unfinishedSetOutputStream;
  private ObjectOutputStream finishedListOutputStream;
  private ObjectOutputStream activitiesListOutputStream;
  private ObjectOutputStream scheduleListOutputStream;
  private ObjectInputStream unfinishedSetInputStream;
  private ObjectInputStream finishedListInputStream;
  private ObjectInputStream activitiesListInputStream;
  private ObjectInputStream scheduleListInputStream;

  private static final String UNFINISHED_FILE_PATH = "./data/unfinished.dat";
  private static final String FINISHED_FILE_PATH = "./data/finished.dat";
  private static final String ACTIVITIES_FILE_PATH = "./data/activities.dat";
}
