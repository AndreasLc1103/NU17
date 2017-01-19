package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Camilo Gonzalez
 *
 */
public class Shooter extends Subsystem {

	private CANTalon shooterMotor = new CANTalon(RobotMap.SHOOTER_MOTOR);
	
    public void initDefaultCommand() {
    	
    }
    
    /**
     * Changes shooter mode to manual and sets a speed
     * @param speed Speed of shooter from -1 to 1
     */
    public void setOpenLoop(double speed) {
    	this.shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	this.shooterMotor.set(speed);
    }
    
    /**
     * Changes shooter mode to close-loop on speed and
     * sets the setpoint to rpm
     * @param rpm Setpoint for speed close-loop
     */
    public void setRpm(double rpm) {
    	this.shooterMotor.changeControlMode(TalonControlMode.Speed);
    	this.shooterMotor.set(rpm);
    }
    
    /**
     * Stops the shooter
     */
    public void stop() {
    	this.setOpenLoop(0);
    }
}

