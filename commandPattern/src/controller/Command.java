package controller;

public interface Command {
	public int getIndex();
	public void execute();
	public void undo();
}
