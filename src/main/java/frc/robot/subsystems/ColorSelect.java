package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ColorSelect extends Subsystem {
  // We have 4 Talon SRX motors (using CAN, NOT PWM), so we need to use TalonSRX
  // From Phoenix 3rd party software
  WPI_VictorSPX m_cSelect = new WPI_VictorSPX(5);
  boolean isOn = false;

  @Override
  public void initDefaultCommand() {
    m_cSelect.configFactoryDefault();
  }

  public void spin() {
      m_cSelect.set(-0.30);

    }


    public void stop() {
        m_cSelect.set(0);
  
      }
  }
