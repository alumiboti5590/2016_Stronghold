package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.autonomous.*;
import org.usfirst.frc.team5590.robot.commands.arm.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CheivalDeFrise extends CommandGroup {
    
    public CheivalDeFrise() {
        requires(Robot.arm);
        requires(Robot.drivetrain);
        
        addSequential(new ArmFloor());
        addSequential(new ArmOpenGate());
        addSequential(new DriveStraightLength(12));
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!CheivalDeFrise deployed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
