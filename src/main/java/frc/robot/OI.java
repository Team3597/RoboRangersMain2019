/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.Grip;
import frc.robot.commands.IncrementPipeline;
import frc.robot.commands.Intake;
import frc.robot.commands.InvertDrive;
import frc.robot.commands.Release;
import frc.robot.commands.ResetGyro;
import frc.robot.commands.Shoot;
import frc.robot.commands.TrackBall;
import frc.robot.commands.DriveForward;

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

  public static final int DRIVE_JOYSTICK_PORT = 0;
  public static final int A_BUTTON_PORT = 1;
  public static final int B_BUTTON_PORT = 2;
  public static final int X_BUTTON_PORT = 3;
  public static final int Y_BUTTON_PORT = 4;
  public static Joystick driveJoystick;
  public static Button buttonA, buttonB, buttonX, buttonY;

  public OI() {
    driveJoystick = new Joystick(DRIVE_JOYSTICK_PORT);

    buttonA = new JoystickButton(driveJoystick, A_BUTTON_PORT);
    buttonB = new JoystickButton(driveJoystick, B_BUTTON_PORT);
    buttonX = new JoystickButton(driveJoystick, X_BUTTON_PORT);
    buttonY = new JoystickButton(driveJoystick, Y_BUTTON_PORT);

    buttonA.whenPressed(new IncrementPipeline());
    buttonB.whileHeld(new TrackBall());
    buttonX.whenPressed(new InvertDrive());
    
    /*
    buttonA.whileHeld(new Intake());
    buttonB.whileHeld(new Shoot());
    buttonX.whileHeld(new Grip());
    buttonY.whileHeld(new Release());
    */
  }
}
