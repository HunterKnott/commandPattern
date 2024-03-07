package controller;

public class UpdateCommand implements Command {
	private String[] parts;
	
	public UpdateCommand(String[] parts) {
		this.parts = parts;
	}
	
	public void execute() {
		
	}
	
	public void undo() {
		
	}
}
