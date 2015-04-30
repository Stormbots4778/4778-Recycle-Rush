package org.usfirst.frc.team4778.robot;


import org.usfirst.frc.team4778.robot.commands.AutomaticDownLift;
import org.usfirst.frc.team4778.robot.commands.AutomaticUpLift;
import org.usfirst.frc.team4778.robot.commands.ResetEncoder;
import org.usfirst.frc.team4778.robot.commands.ToggleGrips;
import org.usfirst.frc.team4778.robot.commands.ToggleKicker;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
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
	
	Joystick leftJoystick = new Joystick(0);
	Joystick rightJoystick = new Joystick(1);
	Button rightTrigger = new JoystickButton(rightJoystick, 1);
	Button button2r = new JoystickButton(rightJoystick, 2);
	Button button3r = new JoystickButton(rightJoystick, 3);
	Button button2l = new JoystickButton(leftJoystick, 2);
	Button leftTrigger = new JoystickButton(leftJoystick, 1);
	public OI() {
		rightTrigger.whenPressed(new ToggleGrips());
		button2r.whenPressed(new AutomaticUpLift());
		button3r.whenPressed(new AutomaticDownLift());
		button2l.whenPressed(new ResetEncoder());
		leftTrigger.whenPressed(new ToggleKicker());
	}
	

	
	
}

