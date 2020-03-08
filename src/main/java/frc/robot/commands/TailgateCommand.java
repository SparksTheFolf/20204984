/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Tailgate;

public class TailgateCommand extends Command {

  public TailgateCommand() {
    requires(Robot.tailgate);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.tailgate.TailgateSoleniod(Tailgate.TailgateDirection.kOut);

  }

  @Override
  protected boolean isFinished() {
     return false;
  }

  @Override
  protected void end() {
    Robot.tailgate.TailgateSoleniod(Tailgate.TailgateDirection.kIn);
  }

 
}
