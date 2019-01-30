/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Shoot extends Command {

  private static final double DEFAULT_SPEED = 0.8d;
  private boolean setSpeed;

  public Shoot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setSpeed = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(setSpeed) {
      Robot.shooter.setDriveSpeed1(DEFAULT_SPEED);
      Robot.shooter.setDriveSpeed2(DEFAULT_SPEED);
      setSpeed = false;
    }
    Robot.shooter.setTankDrive(1d, 1d);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shooter.stop();
    setSpeed = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.shooter.stop();
    setSpeed = true;
  }
}
