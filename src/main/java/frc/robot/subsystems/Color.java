package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Color extends Subsystem {
  // We have 4 Talon SRX motors (using CAN, NOT PWM), so we need to use TalonSRX
  // From Phoenix 3rd party software
  WPI_VictorSPX m_Color = new WPI_VictorSPX(4);
  boolean isOn = false;

  @Override
  public void initDefaultCommand() {
    m_Color.configFactoryDefault();
  }

  public void up() {
      m_Color.set(-0.30);

    }

    public void down() {
        m_Color.set(0.30);
  
      }

    public void stop() {
        m_Color.set(0);
  
      }
  }
