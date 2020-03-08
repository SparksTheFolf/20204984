/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class Auto2CommandGroup extends CommandGroup {
  
  public Auto2CommandGroup() {
    addSequential(new BallIntakeCommand(-1.0), 0.5); 
    addSequential(new DriveDistanceCommand(Constants.DISTANCE_2, Constants.LEFT_MOTOR_1, Constants.RIGHT_MOTOR_1));
    addSequential(new AutoBallOutCommandGroup(0.5, 1.0));
  }
}
