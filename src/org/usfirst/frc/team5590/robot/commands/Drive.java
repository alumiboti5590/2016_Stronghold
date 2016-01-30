package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Drive extends CommandGroup {
	
	public Drive() {
		addParallel(new ArcadeDrive());
	}

}
