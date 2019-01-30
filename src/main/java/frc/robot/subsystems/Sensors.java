/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UpdateSensors;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Add your docs here.
 */
public class Sensors extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Gyro
  public static ADXRS450_Gyro gyro;
  public static final double GYRO_LEFT_BOUND = 60d,
    GYRO_RIGHT_BOUND = 60d;

  //Limelight
  private NetworkTable limeLightTable;

  public Sensors() {
    //Gyro
    gyro = new ADXRS450_Gyro();
    gyro.reset();
    gyro.calibrate();

    //Limelight
    limeLightTable = NetworkTableInstance.getDefault().getTable("limelight");
  }

  //Limelight methods
  public double limeLightGetX() {
    NetworkTableEntry tx = limeLightTable.getEntry("tx");
    double x = tx.getDouble(0d);
    return x;
  }

  public double limeLightGetY() {
    NetworkTableEntry ty = limeLightTable.getEntry("ty");
    double y = ty.getDouble(0d);
    return y;
  }

  public double limeLightGetL() {
    NetworkTableEntry tl = limeLightTable.getEntry("tl");
    double l = tl.getDouble(0d);
    return l;
  }

  public double limeLightGetArea() {
    NetworkTableEntry ta = limeLightTable.getEntry("ta");
    double a = ta.getDouble(0d);
    return a;
  }

  public boolean limeLightTargetFound() {
    NetworkTableEntry tv = limeLightTable.getEntry("tv");
    double v = tv.getDouble(0d);
    if (v == 0d) {
      return false;
    } else {
      return true;
    }
  }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new UpdateSensors());
  }
}
