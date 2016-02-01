package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.commands.Disabled;
import org.usfirst.frc.team5590.robot.commands.Drive;
import org.usfirst.frc.team5590.robot.commands.ManualArmControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private double verticalMotorSpeed = 0.0;
	private double rotationalMotorSpeed = 0.0;

	private static final int ARM_ROTATIONAL_DIO = 4;
	private static final int ARM_VERTICAL_DIO = 5;
	
	private static int breachArmRotationalEncoderSlot_A = 0;
	private static int breachArmRotationalEncoderSlot_B = 1;
	
	private static int breachArmVerticalEncoderSlot_A = 2;
	private static int breachArmVerticalEncoderSlot_B = 3;

	private static SpeedController breachArmRotationalMotor;
	private static SpeedController breachArmVerticalMotor;

	public static Encoder breachArmRotationalEncoder;
	public static Encoder breachArmVerticalEncoder;

	public static void initializeControllers() {

		breachArmRotationalMotor = new TalonSRX(ARM_ROTATIONAL_DIO);
		breachArmVerticalMotor = new TalonSRX(ARM_VERTICAL_DIO);

		breachArmRotationalEncoder = new Encoder(breachArmRotationalEncoderSlot_A, breachArmRotationalEncoderSlot_B,
				false, EncodingType.k2X);
		breachArmRotationalEncoder.setMinRate(.1);
		breachArmRotationalEncoder.setDistancePerPulse(.014);
		breachArmRotationalEncoder.setSamplesToAverage(30);

		breachArmVerticalEncoder = new Encoder(breachArmVerticalEncoderSlot_A, breachArmVerticalEncoderSlot_B, false,
				EncodingType.k2X);
		breachArmVerticalEncoder.setMinRate(.1);
		breachArmVerticalEncoder.setDistancePerPulse(.014);
		breachArmVerticalEncoder.setSamplesToAverage(30);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ManualArmControl());
	}

	public void updateBreachArmY() {
		double logitechJoystickY = OI.logitechController.getMainStickY();
		this.verticalMotorSpeed = logitechJoystickY;
	}

	public void updateBreachArmZ() {
		double logitechJoystickZ = OI.logitechController.getMainStickZ();
		this.rotationalMotorSpeed = logitechJoystickZ;
	}

	public void updateVerticalEncoder(double degrees) {
		breachArmVerticalEncoder.reset();
		if (degrees > 0) {
			while (breachArmVerticalEncoder.getDistance() < degrees) {
				breachArmVerticalMotor.set(0.5);
			}
		} else {
			while (breachArmVerticalEncoder.getDistance() > degrees) {
				breachArmVerticalMotor.set(-0.5);
			}
		}
		breachArmVerticalMotor.set(0);
	}

	public void updateHorizontalEncoder(double degrees) {
		if (degrees > 0){
			while (breachArmRotationalEncoder.getDistance() < degrees) {
				breachArmRotationalMotor.set(0.5);
			}
		} else {
			while (breachArmRotationalEncoder.getDistance() > degrees) {
				breachArmRotationalMotor.set(-0.5);
			}
		}
		breachArmRotationalMotor.set(0);
	}
}
