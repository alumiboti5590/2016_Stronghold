package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.*;
import org.usfirst.frc.team5590.robot.commands.arm.ArmFloor;
import org.usfirst.frc.team5590.robot.commands.arm.ManualArmControl;
import org.usfirst.frc.team5590.robot.commands.arm.ResetArm;
import org.usfirst.frc.team5590.robot.controllers.LogitechX3;
import org.usfirst.frc.team5590.robot.controllers.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * xbox controller should always be port 1 and logitech should be port 2
 */
public class OI {
	
	public static XboxController xboxController = new XboxController(0);
	public static LogitechX3 logitechController = new LogitechX3(1);
	
	public static boolean shooterMode = false;
	
	public OI() { 
		
		logitechController.button7.whenPressed(new ToggleMode());
		xboxController.buttonSelect.whenPressed(new Drive());
		
		if (shooterMode) {
			logitechController.button1.whenPressed(new Shoot());
			logitechController.button2.whileHeld(new Collect());
		} else {
			logitechController.button5.whenPressed(new ArmFloor());	
			logitechController.button3.whenPressed(new ResetArm());	
		}
		
		
	}
}

