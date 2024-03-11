// Hunter Knott, CS 3450, Utah Valley University

package controller;

public class Runner {
	public static void main(String [] args) {
		
		String fileName = "defaultInstructions.dat";
		if (args.length > 0) {
			fileName = args[0];
		}
		Controller app = new Controller();
		app.run(fileName);
	}
}
