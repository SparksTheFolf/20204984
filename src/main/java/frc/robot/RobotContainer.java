/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
  
public class RobotContainer {
  private Joystick driverJoystickLeft = new Joystick(Constants.DRIVER_JOYSTICK_LEFT);
  private Joystick driverJoystickRight= new Joystick(Constants.DRIVER_JOYSTICK_RIGHT);

  private XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);


  Button StraightCommand = new JoystickButton(driverJoystickRight, Constants.DRIVE_STRAIGHT_BUTTON);
  Button ReverseDrive = new JoystickButton(driverJoystickLeft, 1);
  Button BallIntake = new JoystickButton(operatorController, Constants.BALL_INTAKE_BUTTON);
  Button ReverseIntake = new JoystickButton(operatorController, Constants.REVERSE_INTAKE_BUTTON);
  Button BallOutput = new JoystickButton(operatorController, Constants.BALL_OUTPUT_BUTTON);
  Button ReverseHopper = new JoystickButton(operatorController, Constants.REVERSE_HOPPER_BUTTON);
  Button ClimberPistons = new JoystickButton(operatorController, Constants.CLIMBER_PISTONS_BUTTON);
  Button ColorPiston = new JoystickButton(operatorController, Constants.COLOR_PISTON_BUTTON);

  public RobotContainer() {
    
   StraightCommand.whileHeld(new DriveStraightCommand());
   ReverseDrive.whileHeld(new ReverseTankDriveCommand());
   BallIntake.whileHeld(new BallIntakeCommand(Constants.INTAKE_MOTOR_SPEED));
   ReverseIntake.whileHeld(new BallIntakeCommand(Constants.REVERSE_INTAKE_MOTOR_SPEED));
   BallOutput.whileHeld(new BallOutputCommandGroup(.5, Constants.HOPPER_MOTOR_SPEED));
   ReverseHopper.whileHeld(new HopperCommand(Constants.REVERSE_HOPPER_MOTOR_SPEED));
   ClimberPistons.whenReleased(new ClimberPistonsCommand());
   ColorPiston.whenReleased(new ColorPistonCommand());
  }
  
  

  public double GetDriverJoystickLeftRawAxis(int axis) {
    return driverJoystickLeft.getRawAxis(axis);
  }
 
  public double GetDriverJoystickRightRawAxis(int axis) {
    return driverJoystickRight.getRawAxis(axis);
  }
 
  public Joystick getDriverLeft() {
    return driverJoystickLeft;
  }
 
  public Joystick getDriverRight() {
    return driverJoystickRight;
  }

  public double GetOperatorRawAxis(int axis) {
    return operatorController.getRawAxis(axis);
  }

  public XboxController getOperator(){
    return operatorController;
  }
}
