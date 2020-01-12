import java.time.LocalDate;
/**
 * Models a task on
 * @author Akshat Bansal
*/
public class Task extends Activity implements java.io.Serializable, Comparable<Task>{
	/**
	 * Constructs a task record
	 * @param name name of the task
	 * @param category category of the task
	 * @param numHrsSpent number of hours worked on the task
	 * @param numHrsLeft number of hours still to work
	 * @param priority priority of the task
	 * @param deadline deadline of the task
	 * @param note optional note for the task
	*/
	public Task(String name, String category, int numHrsSpent, int numHrsLeft, String priority, String deadline, String note){
		super(name, category, numHrsSpent, note);
		this.numHrsLeft = numHrsLeft;
		this.priority = priority;
		this.deadline = deadline;
	}

	public Task(){
		//default constructor
	}

	@Override
	/**
	 * Adds more #hrs spent on the task and reduces the #hrs left to finish the task
	 * @param numHrs
	*/
	public void investHrs(int numHrs){
		super.investHrs(numHrs);
		numHrsLeft -= numHrs;
	}

	public void incrementHrsReqd(int hrs){
		numHrsLeft += hrs;
	}


	/**
	 * Returns the number of hours left to work on the task
	 * @return number of hours left to work on the task
	*/
	public int getHrsLeft(){
		return numHrsLeft;
	}

	/**
	 * Returns the priority of the task
	 * @return priority of the task
	*/
	public String getPriority(){
		return priority;
	}

	/**
	 * Returns the deadline of the task
	 * @return deadline
	*/
	public String getDeadline(){
		return deadline;
	}

	public int getPriorityInt(){
		int value = 0;
		if(priority.equals("Urgent"))					value = 0;
		else if(priority.equals("Very high"))	value = 1;
		else if(priority.equals("High"))			value = 2;
		else if(priority.equals("Medium"))		value = 3;
		else if(priority.equals("Low"))				value = 4;
		return value;
	}

	public int compareTo(Task otherTask){
		LocalDate ld = java.time.LocalDate.now();

		String[] todayFormat = ld.toString().split("-");
		String[] currentTaskDeadline = deadline.split("-");
		String[] otherTaskDeadline = otherTask.getDeadline().split("-");

		int todayYear	 = Integer.parseInt(todayFormat[0]);
		int todayMonth = Integer.parseInt(todayFormat[1]);
		int todayDate	 = Integer.parseInt(todayFormat[2]);
		int thisDate	 = Integer.parseInt(currentTaskDeadline[0]);
		int thisMonth	 = Integer.parseInt(currentTaskDeadline[1]);
		int thisYear	 = Integer.parseInt(currentTaskDeadline[2]);
		int otherDate  = Integer.parseInt(otherTaskDeadline[0]);
		int otherMonth = Integer.parseInt(otherTaskDeadline[1]);
		int otherYear	 = Integer.parseInt(otherTaskDeadline[2]);

		Day today 	 = new Day(todayYear, todayMonth, todayDate);
		Day thisDay  = new Day(thisYear, thisMonth, thisDate);
		Day otherDay = new Day(otherYear, otherMonth, otherDate);

		double daysBW1 = thisDay.daysFrom(today);
		double daysBW2 = otherDay.daysFrom(today);

		double score1 = (IMPORTANCE_WEIGHT * this.getPriorityInt()) + (URGENCY_WEIGHT * daysBW1);
		System.out.println(score1);
		double score2 = (IMPORTANCE_WEIGHT * otherTask.getPriorityInt()) + (URGENCY_WEIGHT * daysBW2);
		System.out.println(score2);

		if(score1 > score2)	return 1;
		else if(score1 < score2)	return -1;
		else	return 0;
	}


	public void print(){
		System.out.println("TASK NAME:   " + getName());
		System.out.println("CATEGORY:    " + getCategory());
		System.out.println("#hrs spent:  " + getHrsSpent());
		System.out.println("#hrs to work:" + numHrsLeft);
		System.out.println("priority:    " + priority);
		System.out.println("deadline:    " + deadline);
		System.out.println("Note:        " + getNote());
	}

	public static final double IMPORTANCE_WEIGHT = 0.8;
	public static final double URGENCY_WEIGHT = 0.2;

	private int numHrsLeft;
	private String priority;
	private String deadline;
}
