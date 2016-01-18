package org.usfirst.frc.team5590.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5590.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XboxController xboxController = new XboxController(0);
	
	Joystick logitech_1 = new Joystick(1);
	Button button_1 = new JoystickButton(logitech_1, 1),
			button_2 = new JoystickButton(logitech_1, 2),
			button_3 = new JoystickButton(logitech_1, 3),
			button_4 = new JoystickButton(logitech_1, 4),
			button_5 = new JoystickButton(logitech_1, 5),
			button_6 = new JoystickButton(logitech_1, 6),
			button_7 = new JoystickButton(logitech_1, 7),
			button_8 = new JoystickButton(logitech_1, 8),
			button_9 = new JoystickButton(logitech_1, 9),
			button_10 = new JoystickButton(logitech_1, 10),
			button_11 = new JoystickButton(logitech_1, 11),
			button_12 = new JoystickButton(logitech_1, 12);
	
	
			
	
	
	
	// Hello World
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

