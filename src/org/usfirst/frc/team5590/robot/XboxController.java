package org.usfirst.frc.team5590.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxController extends Joystick{
	Button button_a, 
			button_b,
			button_x,
			button_y,
			button_select,
			button_start,
			button_logo;
	
	public XboxController(int port) {
		super(port);
		button_a = new JoystickButton(this, 1);
		button_b = new JoystickButton(this, 2);
		button_x = new JoystickButton(this, 3);
		button_y = new JoystickButton(this, 4);
		button_select= new JoystickButton(this, 5);
		button_start = new JoystickButton(this, 6);
		button_logo = new JoystickButton(this, 7);
		
	}

	public double getLeftTrigger() {
		return this.getRawAxis(2);
	}
	public double getRightTrigger() {
		return this.getRawAxis(3);
	}
	public double getLeftStickX() {
		return this.getRawAxis(0);
	}
	public double getLeftStickY() {
		return this.getRawAxis(1);
	}
	public double getRightStickX() {
		return this.getRawAxis(4);
	}
	public double getRightStickY() {
		return this.getRawAxis(5);
	}
	public double getDPadX () {
		return 0;
	}
	public double getDPadY () {
		return 0;
	}
}
