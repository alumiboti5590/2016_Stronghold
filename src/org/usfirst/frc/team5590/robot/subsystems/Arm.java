package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.commands.Disabled;
import org.usfirst.frc.team5590.robot.commands.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
	private static int breachArmHorizontalMotorSlot = 1;
	private static int breachArmVerticalMotorSlot = 2;
	private static int breachArmHorizontalEncoderSlot_A = 1;
	private static int breachArmHorizontalEncoderSlot_B = 2;
	private static int breachArmVerticalEncoderSlot_A = 3;
	private static int breachArmVerticalEncoderSlot_B = 4;
	
	public static void initializeControllers(){
		SpeedController breachArmHorizontalMotor = new TalonSRX(breachArmHorizontalMotorSlot);
		SpeedController breachVerticleArmMotor = new TalonSRX(breachArmVerticalMotorSlot);
    	
		Encoder breachArmHorizontalEncoder = new Encoder(breachArmHorizontalEncoderSlot_A, breachArmHorizontalEncoderSlot_B, false, EncodingType.k2X);
    	breachArmHorizontalEncoder.setMinRate(.1);
    	breachArmHorizontalEncoder.setDistancePerPulse(.014);
    	breachArmHorizontalEncoder.setSamplesToAverage(30);
    	
    	Encoder breachArmVerticalEncoder = new Encoder(breachArmVerticalEncoderSlot_A, breachArmVerticalEncoderSlot_B, false, EncodingType.k2X);
    	breachArmVerticalEncoder.setMinRate(.1);
    	breachArmVerticalEncoder.setDistancePerPulse(.014);
    	breachArmVerticalEncoder.setSamplesToAverage(30);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new Disabled());
        
    }
}

