/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TrackBall extends Command {
  public TrackBall() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.sensors);
    requires(Robot.chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.sensors.limeLightTargetFound()) {
      double x = Robot.sensors.limeLightGetX();
      x /= 27;
      double a = Robot.sensors.limeLightGetArea();
      /* Determine if robot should drive
       * a > 0.3d to eliminate noise
       */
      boolean drive = a < 5.8d && a > 0.3d;
        if (Math.abs(x) > 0.0001d) {
          if (drive) {
            Robot.chassis.setArcadeDrive(-0.8d, x);
          } else {
            Robot.chassis.setArcadeDrive(0d, x);
          }
        } else if (drive) {
          Robot.chassis.setArcadeDrive(-0.8d, 0d);
        } else {
          Robot.chassis.setArcadeDrive(0d, 0d);
        }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.chassis.setArcadeDrive(0d, 0d);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.chassis.setArcadeDrive(0d, 0d);
  }
}
