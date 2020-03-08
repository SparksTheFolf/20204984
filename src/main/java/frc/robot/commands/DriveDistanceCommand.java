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

public class DriveDistanceCommand extends Command {
  private int d_Distance;
  private double m_left;
  private double m_right;
  public DriveDistanceCommand(int distance, double leftmotor, double rightmotor) {
    d_Distance = distance;
    m_left = leftmotor;
    m_right = rightmotor;
    requires(Robot.driveTrain);

  }

  @Override
  protected void initialize() {
    Robot.driveTrain.ResetEncoders();

  }

  @Override
  protected void execute() {

    Robot.driveTrain.setBrakeMode();
    
    Robot.driveTrain.Drive(m_left, m_right);
    System.out.println(Robot.driveTrain.leftFrontDriveEncoder.getPosition()/0.630972);
  }

  @Override
  protected boolean isFinished() {
    if ( (int)(Robot.driveTrain.leftFrontDriveEncoder.getPosition()/0.630972) == (d_Distance/2)) {
      return true;
    }
    else {
      return false;
     
    }
  }

  @Override
  protected void end() {
    Robot.driveTrain.Drive(0.0, 0.0);   
  }


  @Override
  protected void interrupted() {
  }
}
