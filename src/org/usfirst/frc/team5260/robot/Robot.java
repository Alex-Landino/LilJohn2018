/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5260.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	XboxController xboxcontroller = new XboxController(0);
	
	Victor leftDrive = new Victor(3);
    Victor rightDrive = new Victor(4);

	Victor backClimb = new Victor(0);
	
	Victor trippleClimber = new Victor(2);
	
	Victor leftintake = new Victor(5);
	Victor rightintake = new Victor(6);
	
	Victor frontUpAndDown = new Victor(1);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
	
		//Drive
		  
		double leftStickValue = xboxcontroller.getX(GenericHID.Hand.kLeft);	
		
		//Lift
		
		double rightStickValue = xboxcontroller.getY(GenericHID.Hand.kLeft);
			
				
		//Run left front motor at speed 0
	   
	    leftDrive.set(leftStickValue);	
	    rightDrive.set(leftStickValue);
	    
	    frontUpAndDown.set(rightStickValue);
	    
	    // Left Intakes pulls cube in 
	    
	    if (xboxcontroller.getAButton())
	    {
	        leftintake.set(-1);
	        rightintake.set(1);
	    }else{
	    	leftintake.set(0);
	    	rightintake.set(0);
	    }	    
	    
	    // Left Intakes shoots cube out 
	    if (xboxcontroller.getBButton())
	    {
	        leftintake.set(1);
	        rightintake.set(-1);
	    }
	    else{
	    	leftintake.set(0);
	    	rightintake.set(0);
	    }	    
	    
	    //Climb 
	    //Climb up (left bumper)
	    if (xboxcontroller.getBumper(GenericHID.Hand.kLeft))
	        backClimb.set(1);
	    else
	    	backClimb.set(0);	    
	    
	    //Climb down (right bumper)
	    if (xboxcontroller.getBumper(GenericHID.Hand.kRight))
	    	backClimb.set(-1);
	    else	
	    	backClimb.set(
	    
	    // Tripleclimb X (down)
	    if(xboxcontroller.getXButton())
	    	tripleClimber.set(1);
	    else
	    	tripleClimber.set(0);

	    // Tripleclimb Y (up)
	    if(xboxcontroller.getYButton())
	    	tripleClimber.set(-1);
	    else 
	    	tripleClimber.set(0);

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
