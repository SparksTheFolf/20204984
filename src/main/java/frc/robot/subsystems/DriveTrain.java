/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.TankDriveCommand;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // ***this motor is being used for elevator
  private CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT_ID, MotorType.kBrushless);
  private CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK_ID, MotorType.kBrushless);
  // ***this motor is unplugged
  private CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT_ID, MotorType.kBrushless);
  private CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.Motor_RIGHT_BACK_ID, MotorType.kBrushless);

  // Encoders for the SparkMax
  private CANEncoder leftFrontDriveEncoder = leftFrontDriveMotor.getEncoder();
  private CANEncoder rightFrontDriveEncoder = rightFrontDriveMotor.getEncoder();

  private int displayCounter = 1;

public DriveTrain(){
      leftFrontDriveMotor.setOpenLoopRampRate(0.8);
      leftBackDriveMotor.setOpenLoopRampRate(0.8);
      rightFrontDriveMotor.setOpenLoopRampRate(0.8);
      rightBackDriveMotor.setOpenLoopRampRate(0.8);

      leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
      leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
      rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
      rightBackDriveMotor.setIdleMode(IdleMode.kCoast);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TankDriveCommand(false));

    // Display Encoder values
    SmartDashboard.putNumber("leftFrontDriveEncoder", leftFrontDriveEncoder.getPosition());
    SmartDashboard.putNumber("rightFrontDriveEncoder", rightFrontDriveEncoder.getPosition());
    System.out.println("rightEncoder = " + rightFrontDriveEncoder.getPosition());
  }

// FOR XBOX CONTROLLER
 /* public void tankDrive(XboxController controller, boolean isSlow){
    double left = controller.getRawAxis(Constants.DRIVER_CONTROLLER_LEFT_STICK_Y);
    double right = controller.getRawAxis(Constants.DRIVER_CONTROLLER_RIGHT_STICK_Y);
    if(isSlow) {
      left = left*.4;
      right = right*.4;
    }
    if(Math.abs(left)<0.1){
      left=0;
    }
    if(Math.abs(right)<0.1){
      right=0;
    }
    
    // Apply a curve to the joystick to make it easier to drive at slow speeds
    tankDrive(Math.pow(left, 3),Math.pow(right, 3));
  }


  public void tankDrive(double left, double right){
    leftFrontDriveMotor.set(left);
    leftBackDriveMotor.set(left);
    rightFrontDriveMotor.set(-right);
    rightBackDriveMotor.set(-right);*/
    
    // FOR TANK DRIVE WITH JOYSTICKS
    public void tankDriveLeft(Joystick joystick) {
      // if(Math.abs(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_AXIS)) > 0.1) {
      leftFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_AXIS));
      leftBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_AXIS));
    }
  

    public void tankDriveRight(Joystick joystick) {
      // if(Math.abs(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS)) > 0.1) {
        rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
        rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
      
    

    // FOR ARCADE MODE
     /* public void arcadeDrive(Joystick joystick) {
        if (Math.abs(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS)) > 0.1) {
          leftFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
          leftBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
          rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
          rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_AXIS));
        }
        else {
          leftFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_SIDE));
          leftBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_SIDE));
          rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_SIDE));
          rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_SIDE));
        }
    */
      
      // display Encoder values every 5th time through call
      if (displayCounter==1) {
          SmartDashboard.putNumber("leftFrontDriveEncoder", leftFrontDriveEncoder.getPosition());
          SmartDashboard.putNumber("rightFrontDriveEncoder", rightFrontDriveEncoder.getPosition());
          displayCounter++;
      } else if (displayCounter>=5) {
          displayCounter=1;
      }
      else {
          displayCounter++;
      }
    }
  }
  

  
  

