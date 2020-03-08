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
import frc.robot.subsystems.DriveTrain;;

public class DriveStraightCommand extends Command {

  public DriveStraightCommand() {

    requires(Robot.driveTrain);

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    Robot.driveTrain.setCoastMode();

    double x =  Robot.m_robotContainer.getDriverRight().getRawAxis(Constants.DRIVER_JOYSTICK_AXIS);
    Robot.driveTrain.Drive(x,-x);
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