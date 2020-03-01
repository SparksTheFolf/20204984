/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * Add your docs here.
 */
public class Camera extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  

 public static UsbCamera usbCamera1 = null;

  public class CameraThread extends Thread {

      final int CAMERA1 = 0;

      private int currentCamera = CAMERA1;



      VideoSink server;

      

      public void CameraInit(){

          System.out.println("CameraThread running");

         // currentCamera = CAMERA1;

         myCameraThread = new CameraThread();

         usbCamera1 = CameraServer.getInstance().startAutomaticCapture(myCameraThread.CAMERA1);
 
         myCameraThread.server = CameraServer.getInstance().getServer();
 
     
 
         usbCamera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
 
     
 
         // Test: Get/Set Camera Configuration
 
     
 
         myCameraThread.setCameraConfig();
 
        
 
         myCameraThread.start();
 
         //myCameraThread.setCameraSource();
 
         myCameraThread.setResolutionHigh();
 
         myCameraThread.getCameraConfig();

       }



       // Method for setting a lower camera resolution = lower bandwidth

       // As low we can go before to little pixels

       public void setResolutionLow(){

          System.out.println("CameraThread rsetResolutionLow running");

          usbCamera1.setResolution(150, 150);



      }



      // Method for setting Camera Resoltuion

      //   This seems to be as high as we can go without exceeding bandwidth is 225

      public void setResolutionHigh(){

          System.out.println("CameraThread rsetResolutionHigh running");

          usbCamera1.setResolution(200, 200);

          usbCamera1.setFPS(10);

      }



      // Method for setting the camera being displayed

      //   Because bandwidth limits don't allow both

      public void setCameraSource(){

          System.out.println("CameraThread setCameraSource running");

          server.setSource(usbCamera1);

          SmartDashboard.putString("My Key", "Hello");

      }



      // Method for getting camera settings

      public void getCameraConfig(){

          System.out.println("CameraThread getPrintCameraConfig running");

          String cameraConfig; 

          cameraConfig = usbCamera1.getConfigJson();

          if (cameraConfig.isEmpty() == false) {

              System.out.println(cameraConfig.toString()); //print to console

          }

      }



      // Method for setting camera settings; adjust as needed

      public void setCameraConfig(){

          System.out.println("CameraThread setPrintCameraConfig running");



          /*

          JSONObject cameraConfiguration = new JSONObject();

          cameraConfiguration.put("fps", "3");

          cameraConfiguration.put("raw_brightness", "133");

          cameraConfiguration.put("brightness", "95");

          cameraConfiguration.put("raw_contrast", "5");

          cameraConfiguration.put("contrast", "50");

          String cameraConfigString = cameraConfiguration.toString(); */

          //usbCamera1.setConfigJson(cameraConfigString);

          usbCamera1.setFPS(20);

          usbCamera1.setBrightness(50);  // this works

          usbCamera1.setExposureAuto();  // this works

          //usbCamera1.setExposureManual(50);  // this works

          //usbCamera1.setResolution(500, 500);



          //double currFPS = usbCamera1.getActualFPS();

          //System.out.println("FPS = " + currFPS);

      }

  }

  public static CameraThread myCameraThread;

  protected void initDefaultCommand() {

  }
}





