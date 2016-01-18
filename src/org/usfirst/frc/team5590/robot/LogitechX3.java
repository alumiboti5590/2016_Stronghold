package org.usfirst.frc.team5590.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechX3 extends Joystick{
	
	Button button_1,
			button_2,
			button_3 ,
			button_4,
			button_5,
			button_6 ,
			button_7 ,
			button_8 ,
			button_9,
			button_10,
			button_11,
			button_12;
		
	public LogitechX3(int port) {
		super(port);
		button_1 = new JoystickButton(this, 1);
		button_2 = new JoystickButton(this, 2);
		button_3 = new JoystickButton(this, 3);
		button_4 = new JoystickButton(this, 4);
		button_5 = new JoystickButton(this, 5);
		button_6 = new JoystickButton(this, 6);
		button_7 = new JoystickButton(this, 7);
		button_8 = new JoystickButton(this, 8);
		button_9 = new JoystickButton(this, 9);
		button_10 = new JoystickButton(this, 10);
		button_11 = new JoystickButton(this, 11);
		button_12 = new JoystickButton(this, 12);
		
		
	}
	public double getMainStickX() {
		return 0;
	}
	public double getMainStickY() {
		return 0;
	}
	public double getMainStickZ () {
		return 0;
	}
	public double getSliderY() {
		return 0;
	}
	public double getThumbStickX() {
		return 0;
	}
	public double getThumbStickY() {
		return 0;
	}
}

