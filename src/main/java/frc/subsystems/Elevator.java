/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  /**
   * Creates a new Elevator.
   */
  private WPI_TalonSRX ElevatorMotor = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR);
  private final double speed = 0.5;
  public Elevator() {
  }

  public void forward(){
    ElevatorMotor.set(ControlMode.PercentOutput, speed);
  }
  public void backward(){
    ElevatorMotor.set(ControlMode.PercentOutput, -speed);
  }
  public void stop(){
    ElevatorMotor.set(ControlMode.PercentOutput, 0);
  }

}
