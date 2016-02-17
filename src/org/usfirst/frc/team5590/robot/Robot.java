package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.CheivalDeFrise;
import org.usfirst.frc.team5590.robot.commands.LowBar;
import org.usfirst.frc.team5590.robot.commands.Portcullis;
import org.usfirst.frc.team5590.robot.commands.autonomous.AutonomousGroup;
import org.usfirst.frc.team5590.robot.commands.autonomous.DriveForward;
import org.usfirst.frc.team5590.robot.subsystems.Arm;
import org.usfirst.frc.team5590.robot.subsystems.Collector;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5590.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter = new Shooter();
	public static final Arm arm = new Arm();
	public static final Collector collector = new Collector();
	
	private CameraServer server;

	public static OI oi;
 
	private Command autonomousCommand;

	public SendableChooser defenseChooser;
	public SendableChooser positionChooser;
	public SendableChooser scoringChooser;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
		oi = new OI();
		
		server = CameraServer.getInstance();
	    server.setQuality(50);
	    server.startAutomaticCapture("cam0");
	    
	    defenseChooser = new SendableChooser();
    	defenseChooser.addDefault("Low Bar", LowBar.class);
    	defenseChooser.addObject("Portcullis", Portcullis.class);
    	defenseChooser.addObject("Chieval De Frise", CheivalDeFrise.class);
    	defenseChooser.addObject("Drive Forward", DriveForward.class);
    	SmartDashboard.putData("Defensive Breach", defenseChooser);

    	positionChooser = new SendableChooser();
    	positionChooser.addObject("0/Low Bar", 0);
    	positionChooser.addObject("1", 1);
    	positionChooser.addObject("2", 2);
    	positionChooser.addObject("3", 3);
    	positionChooser.addObject("4", 4);
    	positionChooser.addDefault("5/Spy Box", 5);
    	SmartDashboard.putData("Position Chooser", positionChooser);
    	
    	scoringChooser = new SendableChooser();
    	scoringChooser.addObject("High Goal Scoring", 2);
    	scoringChooser.addObject("Low Goal Scoring", 1);
    	scoringChooser.addDefault("NO GOAL SCORING", 0);
    	SmartDashboard.putData("Shoot Chooser", scoringChooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    @SuppressWarnings("unchecked")
	public void autonomousInit() {
        autonomousCommand = new AutonomousGroup((Class<Command>) defenseChooser.getSelected(), 
    		  (int) positionChooser.getSelected(), (int) scoringChooser.getSelected());
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("TeleOp Init");
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
