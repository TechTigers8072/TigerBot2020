/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Conveyor extends SubsystemBase {
  Ultrasonic frontSensor;
  Ultrasonic middleSensor;
  Ultrasonic backSensor;
  WPI_TalonSRX conveyorMotor;
  public boolean autoConvey = true;

	public Conveyor() {
    frontSensor = new Ultrasonic(1, 2);
    middleSensor = new Ultrasonic(3, 4);
    backSensor = new Ultrasonic(5, 6);

    conveyorMotor = new WPI_TalonSRX(Constants.CAN_CONVEYOR);
  }
  
  public void moveMotor() {
    conveyorMotor.set(0.5);
  }
  
  public void stopMotor() {
    conveyorMotor.set(0);
  }

  public void motorJoystick(double js){
    conveyorMotor.set(js);
  }

  public boolean detectFront() {
    boolean status = false;
    if(frontSensor.getRangeInches() < 5){
      status = true;
    }
    else {
      status = false;
    }
    return status;
  }

  public boolean detectMiddle() {
    boolean status = false;
    if(middleSensor.getRangeInches() < 5){
      status = true;
    }
    else {
      status = false;
    }
    return status;
  }

  public boolean detectBack() {
    boolean status = false;
    if(backSensor.getRangeInches() < 5){
      status = true;
    }
    else {
      status = false;
    }
    return status;
  }

	

    /**
     * This function is called periodically by Scheduler.run
     */
	@Override
	public void periodic() {
	}

}
