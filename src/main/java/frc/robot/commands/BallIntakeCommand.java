/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallIntakeCommand extends Command {
  private double m_speed;
  private int s_time;
  private boolean t_stop = false;  
  public BallIntakeCommand(double speed) {
    requires(Robot.ballIntake);
    m_speed = speed;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.ballIntake.setIntakeMotor(m_speed);

  }

  @Override
  protected boolean isFinished() {
      return false;
  }

  @Override
  protected void end() {
    Robot.ballIntake.setIntakeMotor(0);
  }

}
