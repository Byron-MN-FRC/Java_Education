package testflow;

import java.util.regex.Pattern;

public class AutonSelector {

	private char location = ' ';
	private char targetSide = ' ';
	private char oppositeTargetSide = ' ';

	public AutonSelector(char inputLocation, char inputTargetSide) {
		location = inputLocation;
		targetSide = inputTargetSide;
		oppositeTargetSide = 'L'; // default
		if (targetSide == 'L') { oppositeTargetSide = 'R'; }
	}
	
	private void deliverCube() {
		if (RobotMap.targetScale) {
			System.out.println("Lift mechanism command");
		} 
		System.out.println("Deliver cube command");		
	}
	
	private void driveForward() {
		System.out.println("Drive to switch");	
		if (RobotMap.targetScale) {
			System.out.println("Driver further to scale");
		} 
	}

	private void turn(char direction) {
		System.out.println("Turn to " + direction);	
	}

	private void driveToWall() {
		System.out.println("Drive toward wall");	
		if (location == 'C') {
			System.out.println("Drive further (started at center)");
		}
	}
	
	private void driveAroundSwitch(char direction) {
		System.out.println("Drive Around Switch to " + direction);
		if (RobotMap.targetScale) {
			System.out.println("Driver further to scale");
		} 
	}

	private void driveToTarget() {
		
		// Determine path to target based on starting position of robot
		switch(location) {
		case 'C':
			turn(targetSide);
			driveToWall();
			turn(oppositeTargetSide);
			driveForward();
			deliverCube();
			break;
		case 'L':
			turn('L');
			driveToWall();
			turn('R');
			if (targetSide == 'L') {
				driveForward();
			} else {
				driveAroundSwitch('R');
			}
			deliverCube();
			break;
		case 'R':
			turn('R');
			driveToWall();
			turn('L');
			if (targetSide == 'R') {
				driveForward();
			} else {
				driveAroundSwitch('L');
			}
			deliverCube();
			break;
		default:
			System.out.println("Drive forward");
			break;
		} 		
	}


	public static void main(String[] args) {

		
		
		int delay = Integer.parseInt(args[0]);
		String robotPos = args[1], gameData = args[2], targetScale = args[3];
		
		// Validate gameData is 3 char consisting of L or R
		// boolean valid = Pattern.matches("^(L|R)(L|R)(L|R)$", gameData.toUpperCase());
		boolean valid = Pattern.matches("[LR]{3}", gameData.toUpperCase());
		if (!valid) {
			System.out.println("gamedata is invalid");
		} 
		
		
		/* test combinations 
		System.out.println("LrL=" + Pattern.matches("[LR]{3}", "LrL"));
		System.out.println("LRL=" + Pattern.matches("[LR]{3}", "LRL"));
		System.out.println("LrLx=" + Pattern.matches("[LR]{3}", "LrLx"));
		System.out.println("xrL=" + Pattern.matches("[LR]{3}", "xrL"));
		System.out.println("RRR=" + Pattern.matches("[LR]{3}", "RRR"));
		*/

		//RobotMap.delayInSeconds = (int) SmartDashboard.getNumber("Auton Delay", 0);
		RobotMap.delayInSeconds = delay;
		// String robotPos = SmartDashboard.getString("Robot Start Pos (L,R, or C)", "Non Received");
		char location = Character.toUpperCase(robotPos.charAt(0));
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		char targetSide = gameData.charAt(0); // default to switch side
		// String targetScale = SmartDashboard.getString("Target", "Non Received");  // ?? is there a boolean
		if (targetScale.equalsIgnoreCase("Y")) { 
			RobotMap.targetScale = true; 
			targetSide = gameData.charAt(1);
		} 

		System.out.println("\n\n****  startingPosition=" + location + " targetSide=" + targetSide + " scale="+targetScale  );
		AutonSelector x = new AutonSelector(location, targetSide);
		x.driveToTarget();
	}
}
