package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/** This command sets the speed of both speed controllers to 0.6
 * To make make both tracks drive the robot forward
 */
public class Drive extends Command {

    public Drive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	System.out.println("Initializing Drive Command");
    	Robot.drivetrain.stop();
    }

    protected void execute() {
    	Robot.drivetrain.updateSpeed();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
