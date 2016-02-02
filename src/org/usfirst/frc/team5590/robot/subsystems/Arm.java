package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.OI;
import org.usfirst.frc.team5590.robot.commands.ManualArmControl;

import com.ni.vision.NIVision.GeometricSetupDataItem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private double verticalMotorSpeed = 0.0;
	private double rotationalMotorSpeed = 0.0;

	private static final int ARM_ROTATIONAL_PWM = 4;
	private static final int ARM_VERTICAL_PWM = 5;

	private static int ROTATIONAL_ENCODER_SIGNAL_A = 0;
	private static int ROTATIONAL_ENCODER_SIGNAL_B = 1;

	private static int VERTICAL_ENCODER_SIGNAL_A = 2;
	private static int VERTICAL_ENCODER_SIGNAL_B = 3;

	private static SpeedController rotationalSpeedController;
	private static SpeedController breachArmVerticalMotor;

	public static Encoder rotationalEncoder;
	// public static Encoder breachArmVerticalEncoder;

	public static void initializeControllers() {

		rotationalSpeedController = new TalonSRX(ARM_ROTATIONAL_PWM);
		// breachArmVerticalMotor = new TalonSRX(ARM_VERTICAL_PWM);

		rotationalEncoder = new Encoder(ROTATIONAL_ENCODER_SIGNAL_A, ROTATIONAL_ENCODER_SIGNAL_B,
				false, EncodingType.k4X);

		// breachArmVerticalEncoder = new Encoder(VERTICAL_ENCODER_SIGNAL_A,
		// VERTICAL_ENCODER_SIGNAL_B, false,
		// EncodingType.k2X);
		// breachArmVerticalEncoder.setMinRate(.1);
		// breachArmVerticalEncoder.setDistancePerPulse(.014);
		// breachArmVerticalEncoder.setSamplesToAverage(30);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ManualArmControl());
	}

	public void updateBreachArmY() {
		double logitechJoystickY = OI.logitechController.getMainStickY();
		this.verticalMotorSpeed = logitechJoystickY;
	}

	public void updateRotationalMotor() {
		double logitechJoystickZ = OI.logitechController.getMainStickZ() / 4;
		if (rotationalEncoder.getDistance() > 480) {
			rotationalSpeedController.set(0.0);
		} else {
			rotationalSpeedController.set(logitechJoystickZ * -1);
		}
		System.out.println("Distance: " + rotationalEncoder.getDistance() + " Direction: "
				+ rotationalEncoder.getDirection());
	}

	public void turnPerDegree(double desiredDegree) {
		double desiredDistance = (4 * desiredDegree) / 3;
		int outputDistance = (int) desiredDistance;
		int precision = 1;
		if (desiredDegree > 0) {
			while (rotationalEncoder.getDistance() < outputDistance) {
				rotationalSpeedController.set(.5 / precision);
			}
			// Error handling
			if (Math.abs(rotationalEncoder.getDistance() - outputDistance) > 25) {
				double error = rotationalEncoder.getDistance();
				while (rotationalEncoder.getDistance() > 5 + outputDistance) {
					rotationalSpeedController.set(-.2 / precision);
				}
				precision+=5;
				// End error
			}
		} else {
			while (rotationalEncoder.getDistance() > outputDistance) {
				rotationalSpeedController.set(-.5 / precision);
			}
			// Error Handling
			if (Math.abs(rotationalEncoder.getDistance() - outputDistance) > 25) {
				double error = rotationalEncoder.getDistance();
				while (rotationalEncoder.getDistance() < outputDistance - 5) {
					rotationalSpeedController.set(.2 / precision);
				}
				precision+=5;
				// End error
			}
		}
			rotationalSpeedController.set(0.0);
			System.out.println("Distance: " + rotationalEncoder.getDistance() + " Direction: "
					+ rotationalEncoder.getDirection());
	}
}

// public void updateVerticalEncoder(double degrees) {
// breachArmVerticalEncoder.reset();
// if (degrees > 0) {
// while (breachArmVerticalEncoder.getDistance() < degrees) {
// breachArmVerticalMotor.set(0.5);
// }
// } else {
// while (breachArmVerticalEncoder.getDistance() > degrees) {
// breachArmVerticalMotor.set(-0.5);
// }
// }
// breachArmVerticalMotor.set(0);
// }
//
// public void updateHorizontalEncoder(double degrees) {
// if (degrees > 0){
// while (breachArmRotationalEncoder.getDistance() < degrees) {
// rotationalSpeedController.set(0.5);
// }
// } else {
// while (breachArmRotationalEncoder.getDistance() > degrees) {
// rotationalSpeedController.set(-0.5);
// }
// }
// rotationalSpeedController.set(0);
// }
// }
