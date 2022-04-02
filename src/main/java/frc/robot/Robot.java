/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.BallPickup;
import frc.robot.subsystems.Color;
import frc.robot.subsystems.ColorSelect;
import frc.robot.subsystems.Door;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Winch;
import frc.robot.autonomous.leftAuto;
import frc.robot.autonomous.centerAuto;

//import edu.wpi.first.wpilibj.util.Color;
//import com.revrobotics.ColorSensorV3;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 * 
 * @param <ColorSensorV3>
 */
public class Robot<ColorSensorV3> extends TimedRobot {
  
  private final Joystick m_stick = new Joystick(0);
  

  public static DriveTrain m_driveTrain = new DriveTrain();
  public static Winch m_winch = new Winch();
  public static BallPickup m_BallPickup = new BallPickup();
  public static Door m_door = new Door();
  public static Color m_color = new Color();
  public static ColorSelect m_cSelect = new ColorSelect();
  public static OI m_oi;
  int runCount = 0;
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * Change the I2C port below to match the connection of your color sensor
   */
  //private final I2C.Port i2cPort = I2C.Port.kOnboard;

  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */
  //private final ColorSensorV3 m_colorSensor = new ColorSensorV3(0);


  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    m_chooser.addOption("Left", new leftAuto());
    m_chooser.addOption("Center", new centerAuto());
    //m_chooser.addOption("Right", new RightAuto())
    SmartDashboard.putData("Auto mode", m_chooser);
    
    CameraServer.startAutomaticCapture(0).setResolution(640, 480);
    
    System.out.println("Initialized");
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    String gameData;
    gameData = DriverStation.getGameSpecificMessage();
    if (gameData.length() > 0) {
      switch (gameData.charAt(0))
      {
        case 'B' :
          break;
        case 'G' :
          break;
        case 'R' :
          break;
        case 'Y' :
          break;
        default :
          break;
      }
    }
    else{
    }

    System.out.println(gameData);
  }


  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_driveTrain.driveWithAuton(-0.5, 500);
    m_driveTrain.stop();
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
    }
   
    m_driveTrain.driveWithAuton(0.5, 250);
    m_driveTrain.stop();
    m_driveTrain.driveWithAuton(-0.5, 250);

    m_driveTrain.stop();
    try {
      Thread.sleep(4000);
    } catch (Exception e) {
    }

    m_driveTrain.driveWithAuton(0.5, 3500);

    /*
     String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
     switch(autoSelected) 
     { 
       case "My Auto": autonomousCommand = new MyAutoCommand();
     break; 
     case "Default Auto": default: autonomousCommand = new ExampleCommand();
     break; 
  }
*/

    // schedule the autonomous command (example)
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    m_driveTrain.driveWithJoystick(m_stick);
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    m_driveTrain.driveWithJoystick(m_stick);
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
