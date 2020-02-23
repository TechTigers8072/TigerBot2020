/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.subsystems.Conveyor;

public class AutoConveyor extends CommandBase {
  private Conveyor m_conveyor;
  private Joystick m_gamepad;

  public AutoConveyor(Conveyor conveyor, Joystick gamepad) {
    this.m_conveyor = conveyor;
    this.m_gamepad = gamepad; 
    addRequirements(m_conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean isBall1 = m_conveyor.detectFront();
    boolean isBall2 = m_conveyor.detectMiddle();
    boolean isBall3 = m_conveyor.detectBack();

    if (m_conveyor.isAutoConvey())
    {
      Subsystem.out.println("AutoConvey is set.");
      if (m_gamepad.getRawButtonPressed(5)){
        m_conveyor.moveMotor();
      }
      else if (isBall3 == false){
        m_conveyor.moveMotor();
      }
    }
    else{
      // auto convey is on
      if(isBall1 == false && isBall2 == false && isBall3 == false)
      {
        m_conveyor.stopMotor();
      }
      else if(isBall3 == false && (isBall1 == true || isBall2 == true))
      {
        m_conveyor.moveMotor();
      }
      else
      {
        m_conveyor.stopMotor();
      }
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_conveyor.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
