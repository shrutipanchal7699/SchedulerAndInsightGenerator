/**
 * Models an activity
 * @author Akshat Bansal
*/
public class Activity implements java.io.Serializable{
	/**
	 * Constructs a task record
	 * @param name name of the task
	 * @param category category of the task
	 * @param numHrsSpent number of hours worked on the task
	 * @param note optional note for the task
	*/
	public Activity(String name, String category, int numHrsSpent, String note){
		this.name = name;
		this.category = category;
		this.numHrsSpent = numHrsSpent;
		this.note = note;
	}

	public Activity(){
		//default constructor
	}

	/**
	 * Adds more #hrs spent on the activity
	 * @param numHrs #hrs spent on the activity
	*/
	public void investHrs(int numHrs){
		numHrsSpent += numHrs;
	}

	/**
	 * Returns the name of the task
	 * @return name of the task
	*/
	public String getName(){
		return name;
	}

	/**
	 * Returns the category of the task
	 * @return category of the task
	*/
	public String getCategory(){
		return category;
	}

	/**
	 * Returns the number of hours spent on the task
	 * @return number of hours spent on the task
	*/
	public int getHrsSpent(){
		return numHrsSpent;
	}

	/**
	 * Returns the optional note associated with the task
	 * @return optional note associated with the task
	*/
	public String getNote(){
		return note;
	}

	public void print(){
		System.out.println("TASK NAME:   " + name);
		System.out.println("CATEGORY:    " + category);
		System.out.println("#hrs spent:  " + numHrsSpent);
		System.out.println("Note:        " + note);
	}

	private String name;
	private String category;
	private int numHrsSpent;
	private String note;
}
