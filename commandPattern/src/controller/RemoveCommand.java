package controller;

public class RemoveCommand implements Command {
	private String[] parts;
	private int index;
	private String removed;
	
	public RemoveCommand(String[] parts) {
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
		removed = Controller.getDatabases().get(index).get(parts[2]);
		Controller.getDatabases().get(index).remove(parts[2]);
	}
	
	public void undo() {
		Controller.getDatabases().get(index).add(parts[2], removed);
	}
}