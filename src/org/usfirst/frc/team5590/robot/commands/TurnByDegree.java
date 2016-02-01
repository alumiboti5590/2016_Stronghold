package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnByDegree extends Command {

	private int degree;
	private boolean isComplete;
	
	public TurnByDegree(int degree) {
    	requires(Robot.arm);
    	this.degree = degree;
    	this.isComplete = false;
    }

    protected void initialize() {
    	System.out.println("Initializing Degree Arm Control Command");
    	Arm.rotationalEncoder.reset();
    	//Arm.breachArmVerticalEncoder.reset();
    }

    protected void execute() {
    	Robot.arm.turnPerDegree(this.degree);
    	this.isComplete = false;
    }

    protected boolean isFinished() {
        return isComplete;
    }

    protected void end() {
    	Arm.rotationalEncoder.reset();
    }

    protected void interrupted() {
    }
}
