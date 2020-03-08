/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class AutonomousCommandGroup extends CommandGroup {

  public AutonomousCommandGroup() {
   
    addSequential(new BallIntakeCommand(-1.0), 0.5); 
    addSequential(new DriveDistanceCommand(Constants.DISTANCE_1, Constants.LEFT_MOTOR_1, Constants.RIGHT_MOTOR_1));   
  }
}
