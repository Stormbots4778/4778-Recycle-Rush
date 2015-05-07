package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.leftLift);
    	requires(Robot.rightLift);
    	requires(Robot.drivetrain);
    	
    	RobotMap.gyro.reset();
    	RobotMap.leftEncoderPrimary.reset();
    	RobotMap.rightEncoderPrimary.reset();
    	
    	for (int i=0; i<2; i++) {
    		addSequential(new AutomaticGripUp());
    		Timer.delay(0.15);
    		addSequential(new PIDUpLift()); //Bring lifts up
    		Timer.delay(0.2);
    		addSequential(new TurnToAngle(-20)); //Knock can out of the way
    		Timer.delay(0.1);
    		addSequential(new TurnToAngle(2)); //Return to straight path
    		Timer.delay(0.2);
    		addSequential(new DriveForwardToButton()); //Drive forward to next tote
    		Timer.delay(0.2);
    		addSequential(new PIDDownLift()); //Bring lifts down for next tote
    		Timer.delay(0.75);
    	}
    		RobotMap.rightGripIn.set(false);
    		RobotMap.rightGripOut.set(true);
    		RobotMap.leftGripIn.set(false);
    		RobotMap.leftGripOut.set(true);
    		Timer.delay(0.2);
    		
    		addSequential(new PIDUpLift()); //Pick up the stack of 3 totes
    		Timer.delay(0.2);
    		addSequential(new BackUp()); //Back away from last container
    		addSequential(new TurnToAngle(-70)); //Turn in preparation for scoring
    		Timer.delay(0.1);
    		addSequential(new ForwardToScore()); //Go forward into auto zone
    		Timer.delay(0.1);
    		addSequential(new PIDDownLift()); //Set down the stack
    	
    	//addSequential(new DriveForwardToButton());
    }
}
