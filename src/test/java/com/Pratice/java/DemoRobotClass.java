package com.Pratice.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class DemoRobotClass {
	public static void main(String[] args) throws IOException, AWTException {
		Runtime.getRuntime().exec("notepad");// to open the notepad
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_T);

	}

}
