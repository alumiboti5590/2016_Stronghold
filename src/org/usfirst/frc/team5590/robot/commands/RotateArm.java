package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateArm extends Command {

    public RotateArm() {
    	requires (Robot.arm);
    }

    protected void initialize() {
    	Robot.arm.breachArmHorizontalEncoder.reset();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
