/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Hopper extends Subsystem {

  private TalonSRX hopperMotor = new TalonSRX(Constants.HOPPER_MOTOR);

  public void setHopperMotor(double speed) {
    hopperMotor.set(ControlMode.PercentOutput, speed);
  }
  
  @Override
  public void initDefaultCommand() {
  }
}
