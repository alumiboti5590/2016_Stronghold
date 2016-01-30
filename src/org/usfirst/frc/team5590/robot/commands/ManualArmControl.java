package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualArmControl extends Command {

    public ManualArmControl() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	System.out.println("Initializing Manual Arm Control Command");
    	Arm.breachArmHorizontalEncoder.reset();
    	Arm.breachArmVerticalEncoder.reset();
    }

    protected void execute() {
		Robot.arm.updateBreachArmZ();
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
