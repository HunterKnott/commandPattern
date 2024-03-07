package controller;
import java.io.*;
import java.util.ArrayList;

public class Controller {
	private static ArrayList<Database> databases;
	private ArrayList<Command> commands;
	
	private static void readFile(InputStream name) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader (new InputStreamReader(name))) {
			String line;
			while ((line = reader.readLine()) != null ) {
				// Add some method here that processes a line
				processLine(line);
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
//		System.out.println(stringBuilder.toString());
		
	}
	
	private static void processLine(String line) {
		switch(line.charAt(0)) {
			case 'A':
				String[] parts = line.split(" ");
				String id = parts[1];
				
				boolean dbPresent = false;
				for (Database db : databases) {
					if (db.getID().equals(id)) {
						dbPresent = true;
						break;
					}
				}
				
				// If there's a new database ID, add that to the databases list
				if (!dbPresent) {
					databases.add(makeDatabase(id));
					System.out.println(databases.size());
				}
		}
		
		// Add new commands to the command list
	}
	
	private static Database makeDatabase(String id) {
		return new Database(id);
	}
	
	public void run(String fileName) {
		databases = new ArrayList<>();
		
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
