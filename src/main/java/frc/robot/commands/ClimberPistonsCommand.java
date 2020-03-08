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
import frc.robot.subsystems.ClimberPistons;;

public class ClimberPistonsCommand extends Command {
  
  public ClimberPistonsCommand() {
    requires(Robot.climberpistons);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.climberpistons.ClimberSolenoid(ClimberPistons.ClimberDirection.kOut);    
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  
}
