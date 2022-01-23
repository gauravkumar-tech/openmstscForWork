package com.gk.mstsc;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.jna.platform.win32.Kernel32;

@SpringBootApplication
public class OpenMstscForWorkApplication implements CommandLineRunner{

	static {
		 System.setProperty("java.awt.headless", "false");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OpenMstscForWorkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Robot robot= new Robot();

		String text = "\"C:\\Program Files (x86)\\AccelPro\\AccelPro SSL VPN Client\\AccelPro.exe\"";
		
		String openRemoteDeskTopConnectionSelection = "mstsc.exe";

		
		Runtime runtime = java.lang.Runtime.getRuntime();
		runtime.exec(text);
		
		robot.mouseMove(566, 367);
		
		Thread.sleep(3000);
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		Thread.sleep(3000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		Thread.sleep(3000);
//  step 2
		
		robot.mouseMove(586, 476);
		
		Thread.sleep(3000);
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	
		Thread.sleep(3000);
// step 3
		robot.mouseMove(822, 439);
		
		Thread.sleep(3000);
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		Thread.sleep(3000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
//step 4 -- press enter -- to close cmd popup window
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		

//setp 5 		-- opening mstsc
		Thread.sleep(2000);
		runtime.exec(openRemoteDeskTopConnectionSelection);
		
//step 6 -- press enter on the mstsc
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
//step 7 -- click on the okay button
		Thread.sleep(2000);
		robot.mouseMove(737, 422);
		
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		
//step 8 -- to quit this application from runing
		Thread.sleep(2000);
//		runtime.exec("taskkill /PID 8787 /F");
//		System.exit(0);

		
//		runtime.exec("taskkill /F /IM java.exe");
		
		
		int pid = Kernel32.INSTANCE.GetCurrentProcessId();
		
		
//		closevpn.txt
		
//		C:\Users\Gaurav\Desktop\jarvis
//		File myObj = new File("C:\\Users\\Gaurav\\Desktop\\jarvis\\closevpn.txt");
		
		try {
		
			FileWriter myWriter = new FileWriter("C:\\Users\\Gaurav\\Desktop\\jarvis\\closevpn.txt");
		     myWriter.write("taskkill /PID  "+pid+" /F");
		     myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
//	     System.out.println("Successfully wrote to the file.");
		
//		runtime.exec("taskkill /PID  "+pid+" /F");
//		System.out.println("Gaurav");
		
		
	}
	



}
