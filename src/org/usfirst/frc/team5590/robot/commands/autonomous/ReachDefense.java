package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ReachDefense extends CommandGroup {
    
    public  ReachDefense() {
        addSequential(new DriveStraightTimed(.75, 4));
    }
}
