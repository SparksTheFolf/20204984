/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;
import frc.robot.commands.ColorDriveCommand;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;



public class ColorDrive extends Subsystem {

 private TalonSRX colorMotor = new TalonSRX(Constants.COLOR_MOTOR);
 private final I2C.Port i2cPort = I2C.Port.kOnboard;

 private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

 private final ColorMatch m_colorMatcher = new ColorMatch();

 private final Color kRedTarget = ColorMatch.makeColor(0.143, 0.427, 0.429); //Blue
 private final Color kYellowTarget = ColorMatch.makeColor(0.197, 0.561, 0.240); //Green
 private final Color kBlueTarget = ColorMatch.makeColor(0.561, 0.232, 0.114); //Red
 private final Color kGreenTarget = ColorMatch.makeColor(0.361, 0.524, 0.113); //Yellow

 public void setColorMotor(XboxController controller, int axis){
  double speed = controller.getRawAxis(axis);

  if (Math.abs(speed) > 0.1) {
    colorMotor.set(ControlMode.PercentOutput, controller.getRawAxis(axis));
  }
  else colorMotor.set(ControlMode.PercentOutput, 0);
 
}

  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ColorDriveCommand(false));

  }

  @Override
  public void periodic() {
    Color detectedColor = m_colorSensor.getColor();

    
    double IR = m_colorSensor.getIR();

    SmartDashboard.putNumber("red", detectedColor.red);
    SmartDashboard.putNumber("green", detectedColor.green);
    SmartDashboard.putNumber("blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  
    m_colorMatcher.addColorMatch(kBlueTarget);
    
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
     colorString = "Green";
   } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    int proximity = m_colorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }
}
