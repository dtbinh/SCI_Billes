package billes;

public class Simulation {
	
	public static void printHelp() {
		System.err.println("Use : Java Simulation envWidth envHeight toric marbleSize sleepLength nbMarbles nbTurns");
		System.err.println("envWidth = Environment width (int)");
		System.err.println("envHeight = Environment height (int)");
		System.err.println("toric = Defines if the environment is toric (boolean)");
		System.err.println("marbleSize = Graphical size of each marble (int)");
		System.err.println("sleepLength = Time in ms to wait between each turn (int)");
		System.err.println("nbMarbles = Number of marbles created for the simulation (int)");
		System.err.println("nbTurns = Number of turns of the simulation (int)");
	}
	
	// Use : Java Simulation envWidth envHeight toric marbleSize sleepLength nbMarbles nbTurns
	public static void main(String[] args) {
		
		int width, height, sleepLength, nbMarbles, nbTurns;
		boolean toric;
		
		if(args.length != 7) {
			System.err.println("Error : Unexpected number of parameters");
			printHelp();
			return;
		}
		
		try {
			width = Integer.parseInt(args[0]);
			height = Integer.parseInt(args[1]);
			toric = Boolean.parseBoolean(args[2]);
			sleepLength = Integer.parseInt(args[4]);
			nbMarbles = Integer.parseInt(args[5]);
			nbTurns = Integer.parseInt(args[6]);
		} catch(NumberFormatException e) {
			System.err.println("Error : Incorrect parameters");
			printHelp();
			return;
		}
		
		
		SMA sma = new SMA(width, height, toric, sleepLength);
		sma.init();
		
		for(int i = 0; i < nbMarbles; i++) {
			sma.addAgent();
		}
		
		try {
			sma.run(nbTurns);
		} catch (InterruptedException e) {
			System.err.println("Error : Unexpected interruption during simulation");
		}
		
	}

}