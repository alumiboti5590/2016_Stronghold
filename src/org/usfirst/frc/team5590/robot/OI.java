package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.*;
import org.usfirst.frc.team5590.robot.commands.arm.ArmFloor;
import org.usfirst.frc.team5590.robot.commands.arm.ArmOpenGate;
import org.usfirst.frc.team5590.robot.commands.arm.ManualArmControl;
import org.usfirst.frc.team5590.robot.commands.arm.ResetArm;
import org.usfirst.frc.team5590.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5590.robot.commands.shooter.Shoot;
import org.usfirst.frc.team5590.robot.commands.shooter.ShooterDeploy;
import org.usfirst.frc.team5590.robot.commands.shooter.ShooterRetract;
import org.usfirst.frc.team5590.robot.controllers.LogitechX3;
import org.usfirst.frc.team5590.robot.controllers.XboxController;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * xbox controller should always be port 1 and logitech should be port 2
 */
public class OI {
	
	public XboxController xboxController = new XboxController(0);
	public LogitechX3 logitechController = new LogitechX3(1);
	
	public boolean shooterMode = false;
	
	public OI() { 
		
		// Xbox Controller
		xboxController.buttonSelect.whenPressed(new Drive());
		xboxController.buttonA.whileHeld(new DriveStraight());
		
		System.out.println("Yolo");
		// Logitech Controller
		logitechController.button11.whileHeld(new Shoot());
		logitechController.button7.whenPressed(new ToggleMode());
		logitechController.button2.whileHeld(new Collect());
		logitechController.button3.whenPressed(new ArmFloor());	
		logitechController.button4.whenPressed(new ResetArm());	
		
		logitechController.button1.whenPressed(new TriggerCommands());
		logitechController.button5.whenPressed(new ShooterDeploy());
		logitechController.button6.whenPressed(new ShooterRetract());
		
	}
}

