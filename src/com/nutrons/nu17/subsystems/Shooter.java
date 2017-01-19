package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
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
	
	public static double SHOOTER_P = 0.1;
	public static double SHOOTER_I = 0.0;
	public static double SHOOTER_D = 0.0;
	public static double SHOOTER_F = 0.1;
	public static double SHOOTER_CLOSELOOP_RAMP_RATE = 1.0;
	public static double SHOOTER_RAMP_RATE = 30.0;
	public static double SHOOTER_RPM = 20.0;
	public static int SHOOTER_IZONE = 1;
	
	/**
	 * Creates an object of the Shooter class
	 * Runs initial setup for shooter's CANTalon
	 */
	public Shooter() {
		this.shooterMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		this.shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
		this.shooterMotor.setPID(Shooter.SHOOTER_P, Shooter.SHOOTER_I, Shooter.SHOOTER_D, Shooter.SHOOTER_F, Shooter.SHOOTER_IZONE, Shooter.SHOOTER_RAMP_RATE, 0);
		this.shooterMotor.setProfile(0);
		this.shooterMotor.reverseSensor(false);
		this.shooterMotor.reverseOutput(false);
		this.shooterMotor.enableBrakeMode(false);
		this.shooterMotor.setVoltageRampRate(Shooter.SHOOTER_RAMP_RATE);
		this.shooterMotor.clearStickyFaults();
	}
	
	/**
	 * Initializes the shooter's default command
	 */
    public void initDefaultCommand() {
    	// No default command
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
    
    /**
     * Gets the current shooter's RPM
     * @return Shooter's RPM
     */
    public double getRpm() {
    	return this.shooterMotor.getSpeed();
    }
    
    /**
     * Gets the shooter's setpoint
     * @return Shooter's setpoint
     */
    public double getSetpoint() {
    	return this.shooterMotor.getSetpoint();
    }
}

