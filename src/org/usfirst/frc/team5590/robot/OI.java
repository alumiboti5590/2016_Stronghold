package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.Collect;
import org.usfirst.frc.team5590.robot.commands.Drive;
import org.usfirst.frc.team5590.robot.commands.DriveStraight;
import org.usfirst.frc.team5590.robot.commands.LowGoalShoot;
import org.usfirst.frc.team5590.robot.commands.ManualShooterControl;
import org.usfirst.frc.team5590.robot.commands.PassOff;
import org.usfirst.frc.team5590.robot.commands.Shoot;
import org.usfirst.frc.team5590.robot.commands.ToggleMode;
import org.usfirst.frc.team5590.robot.commands.arm.ArmFloor;
import org.usfirst.frc.team5590.robot.commands.arm.ArmOpenGate;
import org.usfirst.frc.team5590.robot.commands.arm.ManualArmControl;
import org.usfirst.frc.team5590.robot.commands.arm.ResetArm;
import org.usfirst.frc.team5590.robot.commands.shooter.ShooterDown;
import org.usfirst.frc.team5590.robot.commands.shooter.ShooterUp;
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
		xboxController.buttonA.whileHeld(new DriveStraight(0.5));
		
		/**
		 * Toggle mode only changes what the axis does
		 */
		logitechController.button7.whenPressed(new ToggleMode());
		

		logitechController.button1.whenPressed(new Shoot(logitechController.button1));
		
		logitechController.button9.whileHeld(new ManualArmControl(logitechController.button9));
		logitechController.button10.whileHeld(new ManualShooterControl(logitechController.button10));
		
		logitechController.button2.whenPressed(new Collect(logitechController.button2));
				
		logitechController.button3.whenPressed(new ArmFloor());	
		logitechController.button4.whenPressed(new ResetArm());	
		logitechController.button7.whenPressed(new ArmOpenGate());
		
		logitechController.button12.whenPressed(new ShooterUp());
		logitechController.button11.whenPressed(new ShooterDown());
			
		logitechController.button5.whenPressed(new LowGoalShoot(logitechController.button5));
		logitechController.button6.whenPressed(new PassOff(logitechController.button6));
	}
}

