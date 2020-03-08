/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Tailgate extends Subsystem {
  public enum TailgateDirection{kOut, kIn};
  
  private Solenoid TailgateSet;

  public Tailgate() {
    TailgateSet = new Solenoid(0, 3);
    addChild("TailgateSet", TailgateSet);
  }

  public void TailgateSoleniod(TailgateDirection direction) {
    switch(direction) {
      case kOut:
      TailgateSet.set(true);
        break;
      case kIn:
      TailgateSet.set(false);
        break;
    }
  }
 
  @Override
  public void initDefaultCommand() {
   
  }
}
