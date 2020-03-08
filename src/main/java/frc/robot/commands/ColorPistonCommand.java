/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ColorPiston;
import frc.robot.subsystems.ColorPiston.ColorPistonDirection;

public class ColorPistonCommand extends Command {
  
  public ColorPistonCommand() {
    requires(Robot.colorPistons);  
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.colorPistons.ColorPistonSolenoid(ColorPistonDirection.kOut);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
