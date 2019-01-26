/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static RobotDrive chassis;
  public static Spark left;
  public static Spark right;

  public static final double SPEED_DEFAULT = 0.8d;
  private static double driveSpeed1, driveSpeed2;

  public Chassis() {
    left = new Spark(RobotMap.LEFT_DRIVE_MOTOR);
    right = new Spark(RobotMap.RIGHT_DRIVE_MOTOR);
    chassis = new RobotDrive(left, right);
    driveSpeed1 = SPEED_DEFAULT;
    driveSpeed2 = SPEED_DEFAULT;
  }

  public void setTankDrive(double pLeftSpeed, double pRightSpeed) {
    chassis.tankDrive(pLeftSpeed * driveSpeed1, pRightSpeed * driveSpeed2);
  }

  public void setArcadeDrive(double pDriveSpeed, double pRotateSpeed) {
    chassis.arcadeDrive(pDriveSpeed * driveSpeed1, -pRotateSpeed * driveSpeed2);
  }

  public void stop() {
    chassis.tankDrive(0d, 0d);
  }

  public static double getDriveSpeed1() {
    return driveSpeed1;
  }

  public static void setDriveSpeed1(double pSpeed) {
    if (pSpeed > 1.0d || pSpeed < -1.0d) {
      driveSpeed1 = SPEED_DEFAULT;
    } else {
      driveSpeed1 = pSpeed;
    }
  }

  public static double getDriveSpeed2() {
    return driveSpeed1;
  }

  public static void setDriveSpeed2(double pSpeed) {
    if (pSpeed > 1.0d || pSpeed < -1.0d) {
      driveSpeed1 = SPEED_DEFAULT;
    } else {
      driveSpeed1 = pSpeed;
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoystick());
  }
}
