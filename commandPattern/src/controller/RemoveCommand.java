package controller;

public class RemoveCommand implements Command {
	private String[] parts;
	
	public RemoveCommand(String[] parts) {
		this.parts = parts;
	}
	
	public void execute() {
		
	}
	
	public void undo() {
		
	}
}
