package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.commands.*;
import org.usfirst.frc.team5590.robot.commands.shooter.*;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
	
	public Drivetrain drivetrain = Robot.drivetrain;
	public Arm arm = Robot.arm;
	public Shooter shooter = Robot.shooter;
	
	private Command defenseCommand;
	private int position;
	private int shoot = 0;
    
	private static double degrees = 0.0;
	
    public AutonomousGroup(Class<Command> defenseCommand, int position, int shoot) {
    	requires(drivetrain);
    	requires(arm);
    	requires(shooter);

    	try {
			this.defenseCommand = (Command) defenseCommand.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	this.position = (int) position;
    	this.shoot = (int) shoot;
    	
    	this.processPosition();
    	
    	addSequential(new ReachDefense());
    	
    	if (this.position < 5){
	    	addSequential(this.defenseCommand);
	    	addSequential(new DriveStraightTimed(.4,2.5));
    	}
    	
    	addSequential(new Rotate(degrees));
    	
    	if (this.shoot == 2) { 
    		addSequential(new HighGoalScore());
    	} else if (this.shoot == 1) { 
    		addSequential(new LowGoalScore());
    	}
    }
    
    public void processPosition(){
    	//Position 5 is spy box
    	switch(this.position){
    		case 0: degrees = 49;
    		break;
    		case 1: degrees = 42;
    		break;
    		case 2: degrees = 18;
    		break;
    		case 3: degrees = -5;
    		break;
    		case 4: degrees = -25;
    		break;
    		//Spy box
    		case 5: degrees = 116;
    		break;
    		default: degrees = 0;
    		break;
    	}
    	
    }
}
