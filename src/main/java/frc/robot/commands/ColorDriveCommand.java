/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class ColorDriveCommand extends Command {
  
  public ColorDriveCommand(boolean start) {
    requires(Robot.colorDrive);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.colorDrive.setColorMotor(Robot.m_robotContainer.getOperator(), Constants.OPERATOR_LEFT_AXIS);

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
