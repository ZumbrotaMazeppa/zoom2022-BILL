package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {

    // We have 4 Victor SPX motors (using CAN, NOT PWM), so we need to use VictorSPX
    // From Phoenix 3rd party software
    WPI_TalonSRX m_rearRight = new WPI_TalonSRX(2);
    WPI_TalonSRX m_frontRight = new WPI_TalonSRX(1);
    SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(4);
    WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(3);
    SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        m_frontLeft.configFactoryDefault();
        m_frontRight.configFactoryDefault();
        m_rearLeft.configFactoryDefault();
        m_rearRight.configFactoryDefault();
        m_right.setInverted(true);
    }

    public void driveWithAuton(double speed, long drivetime) {
        m_drive.arcadeDrive(speed, 0);
        long targettime = System.currentTimeMillis() +  drivetime;
        while(System.currentTimeMillis() < targettime) {
          m_drive.arcadeDrive(speed, 0);
        }
        m_drive.arcadeDrive(0, 0);
    
        /*m_drive.arcadeDrive(speed, 0);
        long hittime = System.currentTimeMillis() +  drivetime;
        while(System.currentTimeMillis() < hittime);*/
      }

    public void driveWithJoystick(Joystick joystick) {
        double throttle = -joystick.getThrottle();
        if (throttle < 0.5) {
            m_drive.arcadeDrive(joystick.getY() * 0.65, joystick.getTwist() * 0.5);
        } else {
            m_drive.arcadeDrive(joystick.getY(), joystick.getTwist() * 0.65);
        }
    }

    public void driveFromLeft()  {
        m_drive.arcadeDrive(1, 0.5);
 
   }

   public void driveFromCenter()  {
        m_drive.arcadeDrive(0, -0.5);

}

    public void driveFromRight()  {
        m_drive.arcadeDrive(1, -0.5);

}

   public void stop() {
       m_drive.arcadeDrive(0, 0);
   }

}
