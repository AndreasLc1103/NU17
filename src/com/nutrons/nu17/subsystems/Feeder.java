package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.RobotMap;
import com.nutrons.nu17.commands.EnableFeeder;
import com.nutrons.nu17.commands.shooter.EnableShooterCmd;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {

	private CANTalon  FEEDME = new CANTalon(RobotMap.FEEDER_MOTOR);
	public static double Speed = 1.0;

    public void initDefaultCommand() {
    	setDefaultCommand(new EnableFeeder());
    }
    public void Run(double Speed){
		this.FEEDME.changeControlMode(TalonControlMode.PercentVbus);
		this.FEEDME.set(Speed);
		}
  
}

