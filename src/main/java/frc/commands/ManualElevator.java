/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Elevator;

public class ManualElevator extends CommandBase {
  /**
   * Creates a new ManualElevator.
   */
  int POV;
  Elevator m_Elevator;
  public ManualElevator(Elevator elevator, int POV) {
    addRequirements(elevator);
    this.POV = POV;
    this.m_Elevator = elevator;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(POV == -1){
      m_Elevator.stop();
    }
    else if(POV == 0){
      m_Elevator.forward();
    }
    else if(POV == 4){
      m_Elevator.backward();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
