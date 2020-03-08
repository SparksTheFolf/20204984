/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;;

public class TankDriveCommand extends Command {
 
  public TankDriveCommand(boolean isslow) {

    requires(Robot.driveTrain);
  }

  
  @Override
  protected void initialize() {
  }

  
  @Override
  protected void execute() {

    Robot.driveTrain.setCoastMode();
    
    Robot.driveTrain.tankDriveLeft(Robot.m_robotContainer.getDriverLeft());
    Robot.driveTrain.tankDriveRight(Robot.m_robotContainer.getDriverRight());

  }

  
  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}