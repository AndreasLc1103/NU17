package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import com.nutrons.nu17.subsystems.Feeder;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EnableFeeder extends Command {
	private double Speed;
	public EnableFeeder(){
		requires(Robot.feeder);
		this. Speed= Feeder.Speed;
	}
	
    public EnableFeeder(double Speed) {
        requires(Robot.feeder);
       this.Speed= Feeder.Speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.feeder.Run(this.Speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
