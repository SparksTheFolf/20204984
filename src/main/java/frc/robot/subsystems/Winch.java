/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.WinchMotorCommand;



public class Winch extends Subsystem {

  private TalonSRX winchMotor = new TalonSRX(Constants.WINCH_MOTOR);

  public void setWinchMotor(XboxController controller, int axis){
    double speed = controller.getRawAxis(axis);
    winchMotor.setNeutralMode(NeutralMode.Brake);
    if (Math.abs(speed) > 0.1) {
      winchMotor.set(ControlMode.PercentOutput, controller.getRawAxis(axis));
    }
    else {
      winchMotor.set(ControlMode.PercentOutput, 0);
    }
   
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new WinchMotorCommand(false));

  }
}
