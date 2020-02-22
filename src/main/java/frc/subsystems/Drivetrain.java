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


public class Drivetrain extends SubsystemBase {
	/*
	AZTECHS
	private CANSparkMax FrontRight = new CANSparkMax(Constants.CAN_RIGHT_FRONT_WHEEL, MotorType.kBrushless);
	private CANSparkMax FrontLeft = new CANSparkMax(Constants.CAN_LEFT_FRONT_WHEEL, MotorType.kBrushless);
	private CANSparkMax RearRight = new CANSparkMax(Constants.CAN_RIGHT_BACK_WHEEL, MotorType.kBrushless);
	private CANSparkMax RearLeft = new CANSparkMax(Constants.CAN_LEFT_BACK_WHEEL, MotorType.kBrushless);
	*/
	private WPI_TalonSRX RightFront=new WPI_TalonSRX(1);
	private WPI_VictorSPX RightRear=new WPI_VictorSPX(2);
	
	private WPI_TalonSRX LeftFront=new WPI_TalonSRX(3);
	private WPI_VictorSPX LeftRear=new WPI_VictorSPX(4);

	public DifferentialDrive differentialDrive;

	public Drivetrain() {
		RightFront.configFactoryDefault();
		RightRear.configFactoryDefault();
		LeftFront.configFactoryDefault();
		LeftRear.configFactoryDefault();
		
		// Set the rear drives to follow the left and right front drives
		LeftRear.follow(LeftFront);
		RightRear.follow(RightFront);

        differentialDrive = new DifferentialDrive(LeftFront, RightFront);

		//Sets the motors to brake mode
		RightFront.setNeutralMode(NeutralMode.Brake);
		RightRear.setNeutralMode(NeutralMode.Brake);
		LeftFront.setNeutralMode(NeutralMode.Brake);
		LeftRear.setNeutralMode(NeutralMode.Brake);

		// Sets talon motor ramp rate to prevent instantaneous changes in output.
		LeftFront.configOpenloopRamp(0.1);
		RightFront.configOpenloopRamp(0.1);
		

	}
	
	public void arcadeDrive(double forward, double rotation) {
		differentialDrive.arcadeDrive(-forward , rotation);
	}

	public void getJoystickValues(Joystick joystick) {
		System.out.println("Y VALUE: " + joystick.getY() + " X VALUE: " + joystick.getX());
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		differentialDrive.tankDrive(-leftSpeed, -rightSpeed);
	}
	

    /**
     * This function is called periodically by Scheduler.run
     */
	@Override
	public void periodic() {
	}

}
