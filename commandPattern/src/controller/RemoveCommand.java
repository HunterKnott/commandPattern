package controller;

public class RemoveCommand implements Command {
	private String[] parts;
	
	public RemoveCommand(String[] parts) {
		this.parts = parts;
	}
	
	public void execute() {
		System.out.println(String.join(" ", parts));
		
		// Go to the right db in the list
		int i = 0;
		for (Database db : Controller.getDatabases()) {
			if (db.getID().equals(parts[1])) {
				break;
			}
			i++;
		}
		Controller.getDatabases().get(i).remove(parts[2]);
	}
	
	public void undo() {
		
	}
}
