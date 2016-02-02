package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateArm extends Command {

    public RotateArm() {
    	requires (Robot.arm);
    }

    protected void initialize() {
    	System.out.println("Initializing Arm Rotation Command");
    	Arm.rotationalEncoder.reset();
    }

    protected void execute() {
    	Robot.arm.updateRotationalMotor();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
