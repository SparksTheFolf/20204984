/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TankDriveCommand extends Command {
  boolean SLO;
  public TankDriveCommand(boolean isSlow) {
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    SLO = isSlow;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.driveTrain.tankDrive(Robot.m_oi.GetDriverRawAxis(RobotMap.DRIVER_CONTROLLER_LEFT_STICK_Y), Robot.m_oi.GetDriverRawAxis(RobotMap.DRIVER_CONTROLLER_RIGHT_STICK_Y));
    
    // FOR XBOX CONTROLLER
    

    // FOR TANK DRIVE WITH JOYSTICK
    Robot.driveTrain.tankDriveLeft(Robot.m_RobotContainer.getDriverLeft());
     Robot.driveTrain.tankDriveRight(Robot.m_RobotContainer.getDriverRight());


    // FOR ARCADE MODE
   // Robot.driveTrain.arcadeDrive(Robot.m_RobotContainer.getDriverRight());
  }   

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Robot.driveTrain.tankDriveLeft(0);
    System.out.println("Ending Tank Drive Command");
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
