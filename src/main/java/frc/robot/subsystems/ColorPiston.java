/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ColorPistonCommand;


public class ColorPiston extends Subsystem {

  public enum ColorPistonDirection{kOut, kIn};
  private Solenoid ColorPistonSet;
  private static Boolean pistonToggle = false;

  public ColorPiston() {

    ColorPistonSet = new Solenoid(0,7);
    addChild("ColorWheelSet", ColorPistonSet);
  }

  public void ColorPistonSolenoid(ColorPistonDirection direction) {
    ColorPistonSet.set(pistonToggle);

    if(pistonToggle == true) {
      pistonToggle = false;
    }
    else{ 
      pistonToggle = true;
    }
  }
 
  @Override
  public void initDefaultCommand() {
  }
}