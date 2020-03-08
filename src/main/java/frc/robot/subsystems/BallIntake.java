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


public class BallIntake extends Subsystem {
  
  private TalonSRX ballIntakeMotor = new TalonSRX(Constants.BALL_INTAKE_MOTOR);

  public void setIntakeMotor(double speed) {
    ballIntakeMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {   
  }
}
