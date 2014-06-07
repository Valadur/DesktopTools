package src.main;

import java.awt.EventQueue;

import src.gui.Googling;


public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
		    public void run() {
		    	new Googling();
		    }
		});
		
	}
}