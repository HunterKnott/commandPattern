package controller;

public class AddCommand implements Command {
	private String[] parts;
	
	public AddCommand(String[] parts) {
		this.parts = parts;
	}
	
	public void execute() {
		
	}
	
	public void undo() {
		
	}
}
