/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;

//Subsystems Imports
import frc.subsystems.Drivetrain;
import frc.subsystems.Conveyor;
import frc.subsystems.Intake;
import frc.subsystems.Shooter;
//Commands Imports
import frc.commands.DefaultDrive;
import frc.commands.AutoConveyor;
import frc.commands.Manual_Intake;
import frc.commands.AutoDrive;
// Contains joysticks,calls commands and subsystems

public class RobotContainer {    
    //Joystick for the driver
    public final Joystick joystick = new Joystick(0); 
    // Gamepad for the operator
    public final Joystick gamepad = new Joystick(1);
   
    //Subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    private final Conveyor conveyor = new Conveyor();
    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    private Command Automode = new AutoDrive(drivetrain, shooter, conveyor);

    //Joystick and Gamepad buttons
    //private final JoystickButton jsButnShifter = new JoystickButton(this.joystick, 12);
    private final JoystickButton shooterButton = new JoystickButton(this.gamepad, 2);

    //Contains subsystems, OI devices, and commands.
    public RobotContainer(){
        configureButtons();
        drivetrain.setDefaultCommand(new DefaultDrive(drivetrain, joystick));
        conveyor.setDefaultCommand(new AutoConveyor(conveyor, gamepad));
        intake.setDefaultCommand(new Manual_Intake(intake, gamepad));
    }


    private void configureButtons() {
        //Instant commands
        /*SHOOTER*/
        //this.trigger.whenPressed(new InstantCommand(shooterwheel::toggle, shooterwheel));
        shooterButton.whileHeld(new InstantCommand(shooter::shooterOn, shooter));
        shooterButton.whenReleased(new InstantCommand(shooter::shooterOff, shooter));

    }

    public Command getautoCommand(){
        return Automode;
    }
}
