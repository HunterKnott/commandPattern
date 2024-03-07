package controller;

public class AddCommand implements Command {
	private String[] parts;
	
	public AddCommand(String[] parts) {
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
		
		StringBuilder joinedString = new StringBuilder();
		for (int j = 3; i < parts.length; j++) {
		    joinedString.append(parts[j]);
		    if (j < parts.length - 1) {
		        joinedString.append(" ");
		    }
		}
		String result = joinedString.toString();
		
		Controller.getDatabases().get(i).add(parts[2], result);
	}
	
	public void undo() {
		
	}
}
