package controller;
import java.io.*;
import java.util.ArrayList;

public class Controller {
	private static ArrayList<Database> databases = new ArrayList<>();
	private static ArrayList<Command> commands = new ArrayList<>();
	
	private static void readFile(InputStream name) {
		// Think of a better way to do this part, with macro command wrapping
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Command> subCommands = new ArrayList<>();
		boolean inMacroCommand = false;
		
		try (BufferedReader reader = new BufferedReader (new InputStreamReader(name))) {
			String line;
			while ((line = reader.readLine()) != null ) {
				// Add some method here that processes a line
				processLine(line, inMacroCommand, subCommands);
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}	
	}
	
	private static void processLine(String line, boolean inMacroCommand, ArrayList<Command> subCommands) {
		String[] parts = line.split(" ");
		
		switch(line.charAt(0)) {
			case 'A':
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
				}
				
				if (inMacroCommand) {
					subCommands.add(new AddCommand(parts));
				} else {
					commands.add(new AddCommand(parts));
				}
				break;
			case 'U':
				if (inMacroCommand) {
					subCommands.add(new UpdateCommand(parts));
				} else {
					commands.add(new UpdateCommand(parts));
				}
				break;
			case 'R':
				if (inMacroCommand) {
					subCommands.add(new RemoveCommand(parts));
				} else {
					commands.add(new RemoveCommand(parts));
				}
				break;
			case 'B':
				inMacroCommand = true;
				break;
			case 'E':
				commands.add(new MacroCommand(subCommands.toArray(new Command[subCommands.size()])));
				inMacroCommand = false;
				break;
			default:
				System.out.println("Invalid line");
		}
		
		// Add new commands to the command list
	}
	
	private static Database makeDatabase(String id) {
		return new Database(id);
	}
	
	public void run(String fileName) {
		
		// Read the commands, the file name comes from the command line
		InputStream inputStream = Controller.class.getResourceAsStream(fileName);
		readFile(inputStream);
		
		// Make a sequence of command objects from commands
		// Call all execute functions after sequence is complete
		// Print all databases
		// Undo each command, and print the affected database with each undo
		// After all undos, print all databases to ensure they're empty
	}
}
