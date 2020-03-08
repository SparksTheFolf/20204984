/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ClimberPistons extends Subsystem {

  public enum ClimberDirection{kOut, kIn};
  private Solenoid ClimberSet;
  private static Boolean pistonToggle = false;

  public ClimberPistons() {
    ClimberSet = new Solenoid(0, 0);
    addChild("ClimberSet", ClimberSet);
  }

  public void ClimberSolenoid(ClimberDirection direction){
    ClimberSet.set(pistonToggle);

    System.out.println("Piston Toogle" + pistonToggle);

    if(pistonToggle == true) {
      pistonToggle = false;
      SmartDashboard.putNumber("Climber UP", 1);
    }
    else{ 
      pistonToggle = true;
      SmartDashboard.putNumber("Climber DWN", 0);

    }


  }

  @Override
  public void initDefaultCommand() {
  }
}
