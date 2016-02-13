package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowBar extends Command {

    public LowBar() {
    	requires(Robot.drivetrain);
    	setTimeout(10);
    }

    protected void initialize() {
    	Robot.drivetrain.stop();
    	Robot.drivetrain.setSpeed(.2);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }


    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
