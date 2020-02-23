/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

   private double speed;
   private final double speedIncrement = 0.5;
   private boolean isShooterOn;

  WPI_TalonSRX shooterMotor;
  public Shooter() {
    shooterMotor = new WPI_TalonSRX(Constants.SHOOTER_MOTOR);
    speed = 6;
    isShooterOn = false;
  }

public void shooterOn(){
  shooterMotor.setVoltage(speed);
  isShooterOn = true;
}

public void shooterOff(){
  shooterMotor.setVoltage(0);
  isShooterOn = false;
}

public void increaseSpeed(){
  speed += speedIncrement;
}

public void decreaseSpeed(){
  speed -= speedIncrement;
}


public boolean isShooterOn() {
  return isShooterOn;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
