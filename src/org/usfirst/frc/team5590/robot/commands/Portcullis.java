package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Portcullis extends CommandGroup {
    
    public  Portcullis() {
        requires(Robot.arm);
        requires(Robot.drivetrain);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!Portcullis deployed!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
