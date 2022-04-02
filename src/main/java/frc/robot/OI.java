/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.commands.BallIntake;
import frc.robot.commands.winchDown;
import frc.robot.commands.winchUp;
import frc.robot.commands.BallOutput;
import frc.robot.commands.DoorDown;
import frc.robot.commands.DoorUp;
import frc.robot.commands.colorDown;
import frc.robot.commands.colorTest;
import frc.robot.commands.colorUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  Joystick joystick1 = new Joystick(0);
	Button button1 = new JoystickButton(joystick1, 1),
			button2 = new JoystickButton(joystick1, 2),
			button3 = new JoystickButton(joystick1, 3),
			button4 = new JoystickButton(joystick1, 4),
			button5 = new JoystickButton(joystick1, 5),
			button6 = new JoystickButton(joystick1, 6),
			button7 = new JoystickButton(joystick1, 7),
      button8 = new JoystickButton(joystick1, 8),
      button9 = new JoystickButton(joystick1, 9),
      button10 = new JoystickButton(joystick1, 10),
      button11 = new JoystickButton(joystick1, 11),
      button12 = new JoystickButton(joystick1, 12);
  
  public OI() {
    // exampleButton.whenPressed(new ExampleCommand());
    //button1.whenPressed(new vacuumOnOrOff());
    button3.whileHeld(new BallOutput());
    button6.whileHeld(new DoorDown());
    button5.whileHeld(new BallIntake());
    button4.whileHeld(new DoorUp());
    button7.whileHeld(new colorUp());
    button8.whileHeld(new colorDown());
    button9.whileHeld(new colorTest());
    button11.whileHeld(new winchUp());
    button12.whileHeld(new winchDown());
  }


  
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

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
