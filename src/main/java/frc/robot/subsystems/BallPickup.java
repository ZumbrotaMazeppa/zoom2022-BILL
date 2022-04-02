package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class BallPickup extends Subsystem {
  // We have 4 Talon SRX motors (using CAN, NOT PWM), so we need to use TalonSRX
  // From Phoenix 3rd party software
  WPI_VictorSPX m_ballPickupVictorSPX = new WPI_VictorSPX(2);
  boolean isOn = false;

  @Override
  public void initDefaultCommand() {
    m_ballPickupVictorSPX.configFactoryDefault();
  }

  public void intake() {
      m_ballPickupVictorSPX.set(-0.9);

    }

    public void output() {
        m_ballPickupVictorSPX.set(0.5);
  
      }

    public void stop() {
        m_ballPickupVictorSPX.set(0);
  
      }
  }
