/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Drivetrain;
import frc.subsystems.Shooter;
import frc.subsystems.Conveyor;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  private Drivetrain drive;
  private Shooter shooter;
  private Conveyor conveyor;
  
  public AutoDrive(Drivetrain _drive, Shooter _shooter, Conveyor _conveyor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = _drive;
    this.shooter = _shooter;
    this.conveyor = _conveyor; 
    addRequirements(drive);
    addRequirements(shooter);
    addRequirements(conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.shooterOn();
    conveyor.moveMotor();
    new WaitCommand(5); //Change number to shoot 3 balls
    shooter.shooterOff();
    conveyor.stopMotor();
    drive.arcadeDrive(0.5, 0);
    new WaitCommand(1);
    drive.arcadeDrive(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
