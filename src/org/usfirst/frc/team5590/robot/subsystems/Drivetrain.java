package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5590.robot.RobotMap;

/**
 *
 */

public class Drivetrain extends Subsystem {
    
	SpeedController leftTrack = RobotMap.drivetrainLeftTrack;
	SpeedController rightTrack = RobotMap.drivetrainRightTrack;
	RobotDrive robotDrive = RobotMap.robotDrive;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void takeJoystickInput(double left, double right) {
		robotDrive.tankDrive(left, right);
	}
	
	public void setSpeed(double speed) {
		robotDrive.tankDrive(speed, (speed));
	}
	
	public void rotateLeft(double speed) {
		robotDrive.tankDrive(-speed, speed);
	}
	
	public void rotateRight(double speed) {
		robotDrive.tankDrive(speed, -speed);
	}
	
	public void stop() {
		robotDrive.drive(0, 0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

