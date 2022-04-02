package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Winch extends Subsystem {
  // We have 4 Talon SRX motors (using CAN, NOT PWM), so we need to use VictorSRX
  // From Phoenix 3rd party software
  public WPI_VictorSPX m_Winch = new WPI_VictorSPX(1);
  public long time = 0;
  //DigitalInput limitSwitchLower = new DigitalInput(8);

  @Override
  public void initDefaultCommand() {
    m_Winch.configFactoryDefault();
  }

  public void up() {

      m_Winch.set(-0.75);
      /*
      if (time == 0) {
        time = System.currentTimeMillis();
        m_Winch.set(-0.5);
      } else if( System.currentTimeMillis() - time > 2000) { // 50% for 2 seconds
        m_Winch.set(-0.5);
      } else {
        m_Winch.set(-0.5);
      }*/
    }
  

  public void down() {
    time = 0;
   // if(limitSwitchLower.get()) {
     // stop(); 
     // System.out.println("I'm stopping2");
   // }
   // else {
      m_Winch.set(0.75);
    }
  //}

  public void stop() {
    time = 0;
    m_Winch.set(-0.05);
  }
}
