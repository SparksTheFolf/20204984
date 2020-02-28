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


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class RobotContainer {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);
  private Joystick operatorJoystick = new Joystick(Constants.OPERATOR_JOYSTICK);
  private Joystick driverJoystickLeft = new Joystick(Constants.DRIVER_JOYSTICK_LEFT);
  private Joystick driverJoystickRight= new Joystick(Constants.DRIVER_JOYSTICK_RIGHT);

  Button StraightCommand = new JoystickButton(driverController, 5);
  Button driveStraight = new JoystickButton(driverController, 5);
  Button moveSlow = new JoystickButton(driverController, 7);
  Button moveFast = new JoystickButton(driverController, 8);
  Button ballIntakeButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_BALL_INTAKE_BUTTON_LB);
  Button ballBothButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_BALL_BOTH_BUTTON_RB);
  Button colorWheelTurnButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_COLOR_WHEEL_BUTTON_A);
  Button tailgateButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_TAILGATE_BUTTON_START);
  Button winchButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_WINCH_BUTTON_Y);
  Button climberButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_CLIMBER_BUTTON_X);
  Button intakeReverseButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_BALL_REVERSE_BUTTON_BACK);
  Button winchReverseButton = new JoystickButton(operatorJoystick, Constants.OPERATOR_WINCH_REVERSE_BUTTON_B);





  
  public RobotContainer() {


  intakeReverseButton.whileHeld(new BallIntakeCommand(-0.7));
  ballBothButton.whileHeld(new BallSENDOUTBothCommandGroup(1.0));
  ballIntakeButton.whileHeld(new BallIntakeCommand(0.7));
  colorWheelTurnButton.whileHeld(new ColorWheelTurnCommand(1.0));
  tailgateButton.whileHeld(new TailgateCommand());
  winchButton.whileHeld(new WinchMoveCommand(1.0));
  winchReverseButton.whileHeld(new WinchMoveCommand(-0.7)); // Winch Reverse
  climberButton.whenReleased(new ClimberMoveCommand());
  }


public double GetDriverRawAxis(int axis) {
    return driverController.getRawAxis(axis);
  }

  public boolean GetDriverButton(int button) {
    return driverController.getRawButton(button);
  }

  public Joystick getOperator() {
    return operatorJoystick;
  }
  public XboxController getDriver(){
    return driverController;
  }

public double getDriverButton(int operatorBallintakeButtonX) {
	return 0;
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


}
