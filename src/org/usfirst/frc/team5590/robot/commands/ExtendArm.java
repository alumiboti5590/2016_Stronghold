package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendArm extends Command {

    public ExtendArm() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	Arm.breachArmVerticalEncoder.reset();
    	System.out.println("Initializing Arm Extension Command");
    }

    protected void execute() {
    	Robot.arm.updateBreachArmY();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
