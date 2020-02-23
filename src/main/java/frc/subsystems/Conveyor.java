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

  public void setAutoConvey() {
    autoConvey = true;
  }

  public void clearAutoConvey() {
    autoConvey = false;
  }

  public boolean isAutoConvey() {
    return autoConvey;
  }

  public boolean detectFront() {
    boolean status = false;
    double dist = frontSensor.getRangeInches();
    if ((dist >= 6) && (dist<=8.5)) {
      status = false;
    }
    else {
      status = true;
    }
    return status;
  }

  public boolean detectMiddle() {
    boolean status = false;
    double dist = middleSensor.getRangeInches();

    if ((dist >= 6) && (dist<=8.5)) {
      status = false;
    }
    else {
      status = true;
    }
    return status;
  }

  public boolean detectBack() {
    boolean status = false;
    double dist = backSensor.getRangeInches();

    if((dist >= 6) && (dist<=8.5)) {
      status = false;
    }
    else {
      status = true;
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
