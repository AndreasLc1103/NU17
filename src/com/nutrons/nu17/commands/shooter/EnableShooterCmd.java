package com.nutrons.nu17.commands.shooter;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Camilo Gonzalez
 *
 */
public class EnableShooterCmd extends Command {

	private double rpm;
	
	public EnableShooterCmd() {
		requires(Robot.shooter);
		this.rpm = Shooter.SHOOTER_RPM;
	}
	
    public EnableShooterCmd(double rpm) {
        requires(Robot.shooter);
        this.rpm = rpm;
    }

    protected void initialize() {
    	Robot.shooter.setRpm(this.rpm);
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
