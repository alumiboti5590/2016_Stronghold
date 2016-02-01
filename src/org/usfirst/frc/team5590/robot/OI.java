package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.*;
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
		
		if (shooterMode) {
			logitechController.button1.whenPressed(new Shoot());
			logitechController.button1.whenReleased(new StopShooting());
			logitechController.button2.whileHeld(new Collect());
			logitechController.button2.whenReleased(new StopCollecting());
		} else {
			logitechController.button5.whenPressed(new TurnByDegree(90));
			logitechController.button3.whenPressed(new TurnByDegree(-90));
			logitechController.button6.whenPressed(new TurnByDegree(180));
			logitechController.button4.whenPressed(new TurnByDegree(-180));
			
		}
		
		
	}
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	//cackerman
}

