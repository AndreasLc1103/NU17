package com.nutrons.nu17.commands.shooter;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Camilo Gonzalez
 *
 */
public class RunShooterCmd extends Command {

	private double speed;
	
	public RunShooterCmd() {
		requires(Robot.shooter);
		this.speed = 0.9;
	}
	
    public RunShooterCmd(double speed) {
        requires(Robot.shooter);
        this.speed = speed;
    }

    protected void initialize() {
    	Robot.shooter.setOpenLoop(speed);
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
