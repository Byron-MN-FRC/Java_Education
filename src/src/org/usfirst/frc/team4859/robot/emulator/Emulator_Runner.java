package src.org.usfirst.frc.team4859.robot.emulator;

import java.awt.Color;

public class Emulator_Runner {

	public Emulator_Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		RobotEmulator window = new RobotEmulator();
		window.main(null);
		window.getTextField().setBackground(Color.blue);
	}
}
