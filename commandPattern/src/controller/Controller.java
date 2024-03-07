package controller;
import java.io.*;
import java.util.ArrayList;

public class Controller {
	private static void readFile(InputStream name) {
		ArrayList<Command> commands = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader (new InputStreamReader(name))) {
			String line;
			while ((line = reader.readLine()) != null ) {
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
		System.out.println(stringBuilder.toString());
		
	}
	
	public void run(String fileName) {
		// Read the commands, the file name comes from the command line
		InputStream inputStream = Controller.class.getResourceAsStream(fileName);
		readFile(inputStream);
		
		// Make a list of databases from commands
		// Make a sequence of command objects from commands
		// Call all execute functions after sequence is complete
		// Print all databases
		// Undo each command, and print the affected database with each undo
		// After all undos, print all databases to ensure they're empty
	}
}
