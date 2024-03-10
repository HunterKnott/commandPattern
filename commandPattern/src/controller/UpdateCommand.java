package controller;

public class UpdateCommand implements Command {
	private String[] parts;
	private int index;
	private String previous;
	
	public UpdateCommand(String[] parts) {
		this.parts = parts;
		
		// Go to the right db in the list
		index = 0;
		for (Database db : Controller.getDatabases()) {
			if (db.getID().equals(parts[1])) {
				break;
			}
			index++;
		}
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void execute() {
		previous = Controller.getDatabases().get(index).get(parts[2]);
		
		// A value is a string that could have spaces in it
		StringBuilder joinedString = new StringBuilder();
		for (int j = 3; j < parts.length; j++) {
			joinedString.append(parts[j]);
			if (j < parts.length - 1) {
				joinedString.append(" ");
			}
		}
		String result = joinedString.toString();
		
		Controller.getDatabases().get(index).update(parts[2], result);
	}
	
	public void undo() {
		Controller.getDatabases().get(index).update(parts[2], previous);
	}
}