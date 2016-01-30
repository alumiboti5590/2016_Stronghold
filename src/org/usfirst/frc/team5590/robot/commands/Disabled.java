package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Resets Encoders when the Arm subsystem is initialized.
 */
public class Disabled extends Command {

    public Disabled() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	System.out.println("Encoders Have Been Reset For Start");
    	Arm.breachArmHorizontalEncoder.reset();
    	Arm.breachArmVerticalEncoder.reset();
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
