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
	private double horizontalMotorSpeed = 0.0;

	private static int breachArmHorizontalMotorSlot = 1;
	private static int breachArmVerticalMotorSlot = 2;
	private static int breachArmHorizontalEncoderSlot_A = 1;
	private static int breachArmHorizontalEncoderSlot_B = 2;
	private static int breachArmVerticalEncoderSlot_A = 3;
	private static int breachArmVerticalEncoderSlot_B = 4;

	private static SpeedController breachArmHorizontalMotor;
	private static SpeedController breachArmVerticalMotor;

	public static Encoder breachArmHorizontalEncoder;
	public static Encoder breachArmVerticalEncoder;

	public static void initializeControllers() {

		breachArmHorizontalMotor = new TalonSRX(breachArmHorizontalMotorSlot);
		breachArmVerticalMotor = new TalonSRX(breachArmVerticalMotorSlot);

		breachArmHorizontalEncoder = new Encoder(breachArmHorizontalEncoderSlot_A, breachArmHorizontalEncoderSlot_B,
				false, EncodingType.k2X);
		breachArmHorizontalEncoder.setMinRate(.1);
		breachArmHorizontalEncoder.setDistancePerPulse(.014);
		breachArmHorizontalEncoder.setSamplesToAverage(30);

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
		this.horizontalMotorSpeed = logitechJoystickZ;
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
			while (breachArmHorizontalEncoder.getDistance() < degrees) {
				breachArmHorizontalMotor.set(0.5);
			}
		} else {
			while (breachArmHorizontalEncoder.getDistance() > degrees) {
				breachArmHorizontalMotor.set(-0.5);
			}
		}
		breachArmHorizontalMotor.set(0);
	}
}
