package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.commands.*;

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
	
	
    public  AutonomousGroup(Object defenseCommand, Object position, Object shoot) {
    	requires(drivetrain);
    	requires(arm);
    	requires(shooter);
    	
    	this.defenseCommand = (Command) defenseCommand;
    	this.position = (int) position;
    	this.shoot = (int) shoot;
    	
    	this.processPosition();
    	
    	addSequential(this.defenseCommand);
    	addSequential(new Rotate(degrees));
    	if(this.shoot==2){ addSequential(new HighGoalScore());
    	} else if(this.shoot==1){ addSequential(new LowGoalScore());
    	} else {
    		
    	}   
    }
    
    public void processPosition(){
    	//Position 5 is spy box
    	switch(this.position){
    		case 0: degrees = 60;
    		break;
    		case 1: degrees = 15;
    		break;
    		case 2: degrees = 0;
    		break;
    		case 3: degrees = -15;
    		break;
    		case 4: degrees = -60;
    		break;
    		//Spy box
    		case 5: degrees = 10;
    		break;
    		default: degrees = 0;
    		break;
    	}
    	
    }
}
