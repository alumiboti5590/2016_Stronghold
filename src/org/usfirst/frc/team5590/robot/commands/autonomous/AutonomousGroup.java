package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {
	
	Command defenseCommand;
	int position;
	boolean shoot;
    
	private static double degrees = 0.0;
	
	
    public  AutonomousGroup(Command defenseCommand, int position, boolean shoot) {
    	this.defenseCommand = defenseCommand;
    	this.position = position;
    	this.shoot = shoot;
    	
    	this.processPosition();
    	
    	addSequential(this.defenseCommand);
    	addSequential(new Rotation(degrees));
    	if(this.shoot){addSequential(new Shoot());}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
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
