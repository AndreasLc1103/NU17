package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static double SHOOTER_CLOSELOOP_RAMP_RATE = 0.0;
	public static double SHOOTER_RAMP_RATE = 0.0;
	public static double SHOOTER_RPM = 6200.0;
	public static int SHOOTER_IZONE = 0;
	
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
    
    public void dashboard() {
    	SmartDashboard.putNumber("shooter_current_rpm", this.getRpm());
    	SmartDashboard.putNumber("shooter_set_rpm", Shooter.SHOOTER_RPM);
    	SmartDashboard.putNumber("shooter_setpoint", this.getSetpoint());
    	SmartDashboard.putNumber("shooter_p", Shooter.SHOOTER_P);
    	SmartDashboard.putNumber("shooter_i", Shooter.SHOOTER_I);
    	SmartDashboard.putNumber("shooter_d", Shooter.SHOOTER_D);
    	SmartDashboard.putNumber("shooter_f", Shooter.SHOOTER_F);
    	SmartDashboard.putNumber("shooter_closeloop_ramp_rate", Shooter.SHOOTER_CLOSELOOP_RAMP_RATE);
    	SmartDashboard.putNumber("shooter_ramp_rate", Shooter.SHOOTER_RAMP_RATE);
    	SmartDashboard.putNumber("shooter_izone", Shooter.SHOOTER_IZONE);
    	
    	Shooter.SHOOTER_P = SmartDashboard.getNumber("shooter_p", Shooter.SHOOTER_P);
    	Shooter.SHOOTER_I = SmartDashboard.getNumber("shooter_i", Shooter.SHOOTER_I);
    	Shooter.SHOOTER_D = SmartDashboard.getNumber("shooter_d", Shooter.SHOOTER_D);
    	Shooter.SHOOTER_F = SmartDashboard.getNumber("shooter_f", Shooter.SHOOTER_F);
    	Shooter.SHOOTER_CLOSELOOP_RAMP_RATE = SmartDashboard.getNumber("shooter_closeloop_ramp_rate", Shooter.SHOOTER_CLOSELOOP_RAMP_RATE);
    	Shooter.SHOOTER_RAMP_RATE = SmartDashboard.getNumber("shooter_ramp_rate", Shooter.SHOOTER_RAMP_RATE);
    	Shooter.SHOOTER_RPM = SmartDashboard.getNumber("shooter_set_rpm", Shooter.SHOOTER_RPM);
    	Shooter.SHOOTER_IZONE = (int) SmartDashboard.getNumber("shooter_izone", Shooter.SHOOTER_IZONE);
    }
}

