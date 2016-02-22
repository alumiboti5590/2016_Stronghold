package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.arm.ArmFloor;
import org.usfirst.frc.team5590.robot.commands.arm.ArmOpenGate;
import org.usfirst.frc.team5590.robot.commands.autonomous.DriveStraightLength;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Portcullis extends CommandGroup {
    
    public  Portcullis() {
        requires(Robot.arm);
        requires(Robot.drivetrain);
        
        addSequential(new ArmFloor());
        addSequential(new ArmOpenGate());
        addSequential(new DriveStraightLength(12));
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!Portcullis deployed!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
