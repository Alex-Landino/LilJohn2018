package org.usfirst.frc.team5260.robot;

import java.util.Vector;
	
	/**
	 * @author CaRobotics FRC Team 619
	 */
	public class ThreadManager {
	    
	    private Vector threadList = new Vector();
	    
	    public void addThread(RobotThread thread){
	        threadList.addElement(thread);
	    }
	    
	    public void killAllThreads(){
	        for(int i=0;i<threadList.size();i++){
	            RobotThread t = (RobotThread) threadList.elementAt(i);
	            if(t != null) t.stopRunning();
	        }
	        for(int i=0;i<threadList.size();i++){
	            if(threadList.elementAt(i)==null) threadList.removeElementAt(i);
	        }
	    }
}
