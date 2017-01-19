package com.nutrons.nu17.commands.shooter;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Camilo Gonzalez
 *
 */
public class DisableShooterCmd extends Command {

    public DisableShooterCmd() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.stop();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
