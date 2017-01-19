package com.nutrons.nu17;

import com.nutrons.nu17.commands.shooter.DisableShooterCmd;
import com.nutrons.nu17.commands.shooter.EnableShooterCmd;
import com.nutrons.nu17.commands.shooter.RunShooterCmd;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick operatorPad = new Joystick(RobotMap.OPERATOR_PAD);
	
	private Button enableShooterButton = new JoystickButton(this.operatorPad, 1);
	private Button disableShooterButton = new JoystickButton(this.operatorPad, 2);
	private Button manualShooterButton = new JoystickButton(this.operatorPad, 3);
	
	public OI() {
		this.enableShooterButton.whenPressed(new EnableShooterCmd());
		this.disableShooterButton.whenPressed(new DisableShooterCmd());
		
		this.manualShooterButton.whenPressed(new RunShooterCmd());
		this.manualShooterButton.whenReleased(new DisableShooterCmd());
	}
}