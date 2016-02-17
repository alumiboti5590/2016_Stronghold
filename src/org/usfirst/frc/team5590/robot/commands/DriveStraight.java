package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.Robot;

/**
 *
 */
public class DriveStraight extends Command {
	
	public Drivetrain drivetrain = Robot.drivetrain;
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private static final double CORRECTION_DEGREE_PERCENT = .05;
	double speed;

    public DriveStraight(double speed) {
    	this.speed = speed;
        requires(drivetrain);
        gyro = new ADXRS450_Gyro();             
        drivetrain.setExpiration(696.9);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro.reset();
    	drivetrain.stop();
    	System.out.println("Driving straight");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double correctionValue = gyro.getAngle() * CORRECTION_DEGREE_PERCENT;
        drivetrain.spinDrive(speed, correctionValue); // drive towards heading 0
        Timer.delay(0.004);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.stop();
    }
}
