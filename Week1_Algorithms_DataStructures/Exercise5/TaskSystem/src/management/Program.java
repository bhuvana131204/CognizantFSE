package management;

public class Program {
	public static void main(String args[]) {
		TaskManagement tm = new TaskManagement();
		tm.addTask(new Task("1","Analysis","In progress"));
		tm.addTask(new Task("2","Management","Completed"));
		tm.addTask(new Task("3","Testing","To be done"));
		
		System.out.println("Tasks:");
		tm.traverseTasks();
		
		System.out.println("Searching for task with ID 3:");
		Task tsk = tm.searchTask("3");
		System.out.println(tsk != null ? tsk : "No Task found");
		
		System.out.println("Deleting task with ID 3:");
		tm.deleteTask("3");
		
		System.out.println("All tasks after deletion:");
		tm.traverseTasks();
		
	}
}
