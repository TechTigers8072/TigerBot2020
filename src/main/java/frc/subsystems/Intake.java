/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  WPI_VictorSPX IntakeMotor;
  WPI_TalonSRX Drawbridge1, Drawbridge2;
  public Intake() {

    IntakeMotor = new WPI_VictorSPX(Constants.CAN_INTAKE);
    Drawbridge1 = new WPI_TalonSRX(Constants.CAN_DRAWBRIDGE_LEFT);
    Drawbridge2 = new WPI_TalonSRX(Constants.CAN_DRAWBRIDGE_RIGHT);
    IntakeMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void IntakeForwards() {
    IntakeMotor.set(0.5);
  }
  public void IntakeBackwards() {
    IntakeMotor.set(-0.5);
  }
  public void IntakeStop() {
    IntakeMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
