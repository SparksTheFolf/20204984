/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.AutonomousCommandGroup;
import frc.robot.commands.TankDriveCommand;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.SPI; // for navx

public class DriveTrain extends Subsystem {


 // Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

/*
  private static CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  private static CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  private static CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  private static CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);
*/



  // Left
  private static  CANSparkMax m_leadLeftMotor;
  private CANSparkMax m_followLeftMotor;

  // Right
  private static CANSparkMax m_leadRightMotor;
  private CANSparkMax m_followRightMotor;



  public CANEncoder leftFrontDriveEncoder = m_leadLeftMotor.getEncoder();
  private CANEncoder rightFrontDriveEncoder = m_leadRightMotor.getEncoder();

  public double driveTrainEncoder;
  public static AHRS m_driveTrainGyro; // navX

  private float ProportionalScale = .05f;
  private boolean shouldContinue;
  public boolean done;

  private int displayCounter = 1;

  private int testcounter = 1;
  
  public boolean myautotoggle;

 // myautotoggle = myAutotoggle;

  public DriveTrain() { 

    if ( myautotoggle == false){
      
  }

   // myautotoggle = myAutoToggle;


   m_leadLeftMotor.setOpenLoopRampRate(0.8);
    //leftBackDriveMotor.setOpenLoopRampRate(0.8);
    m_leadRightMotor.setOpenLoopRampRate(0.8);
   // rightBackDriveMotor.setOpenLoopRampRate(0.8);

    
    try {
      m_driveTrainGyro = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) {
      DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    }
    if (m_driveTrainGyro != null) {
      m_driveTrainGyro.reset();
    }
  }

  

  

  public static void setBrakeMode() {
    m_leadLeftMotor.setIdleMode(IdleMode.kBrake);
     // leftBackDriveMotor.setIdleMode(IdleMode.kBrake);
     m_leadRightMotor.setIdleMode(IdleMode.kBrake);
      //rightBackDriveMotor.setIdleMode(IdleMode.kBrake);
    }
  

  public static void setCoastMode() {
    m_leadLeftMotor.setIdleMode(IdleMode.kCoast);
   // leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
   m_leadRightMotor.setIdleMode(IdleMode.kCoast);
   // rightBackDriveMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand(false));
    // Display Encoder values
    if (leftFrontDriveEncoder != null) {
      SmartDashboard.putNumber("leftFrontDriveEncoder", leftFrontDriveEncoder.getPosition());
      SmartDashboard.putNumber("rightFrontDriveEncoder", rightFrontDriveEncoder.getPosition());
    }
    if (m_driveTrainGyro != null) {
      SmartDashboard.putNumber("NavXGyro", m_driveTrainGyro.getAngle());
    }
    System.out.println("rightEncoder = " + rightFrontDriveEncoder.getPosition());
  }

  // A command that turns the Robot a certain amount of degrees in place.
  public boolean NavXTurn(double degrees) {
    m_driveTrainGyro.reset();
    double speed = 1;
    if (degrees < 0) {
      speed *= -1;
      degrees = Math.abs(degrees);
    }
    boolean hasCompletedTurn = false;
    System.out.println("NavXAngle= " + m_driveTrainGyro.getAngle());
    while (Math.abs(m_driveTrainGyro.getAngle()) <= degrees * .6) {
      Drive(.25 * speed, .25 * speed);
    }
    while (Math.abs(m_driveTrainGyro.getAngle()) <= degrees * .8) {
      Drive(.20 * speed, .20 * speed);
    }
    while (Math.abs(m_driveTrainGyro.getAngle()) <= degrees) {
      Drive(.15 * speed, .15 * speed);
    }
    Drive(0, 0);
    System.out.println("Finished with NavX Angle= " + m_driveTrainGyro.getAngle());
    m_driveTrainGyro.reset();
    hasCompletedTurn = true;
    return hasCompletedTurn;

  }

  public void tankDriveLeft(Joystick joystick) {
    m_leadLeftMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
   // leftBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void tankDriveRight(Joystick joystick) {
    m_leadRightMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
   // rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveLeft(Joystick joystick) {
    m_leadLeftMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
   // leftBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveRight(Joystick joystick) {
    m_leadRightMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
    //rightBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }
  public void Drive(double left, double right) {
    m_leadLeftMotor.set(left);
    //leftBackDriveMotor.set(left);
    m_leadRightMotor.set(right);
    //rightBackDriveMotor.set(right);

  }

  public void ResetEncoders() {
    leftFrontDriveEncoder.setPosition(0.0);  
    rightFrontDriveEncoder.setPosition(0.0);  
  }

}





  


