package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;




//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Door extends Subsystem {
    // We have 4 Talon SRX motors (using CAN, NOT PWM), so we need to use TalonSRX
    // From Phoenix 3rd party software
    WPI_VictorSPX m_doorVictorSPX = new WPI_VictorSPX(3);
    boolean isOn = false;
    public DigitalInput limitSwitch  = new DigitalInput(9);

    @Override
    public void initDefaultCommand() {
        m_doorVictorSPX.configFactoryDefault();
  }




  public void open() {
    //if (limitSwitch.get()) {
      //stop();
    //}
    //else {
     m_doorVictorSPX.set(0.85);
      }
    //}

  public void close() {
      m_doorVictorSPX.set(-0.85);

    }

  public void stop() {
      m_doorVictorSPX.set(0);
  
      }
  }
