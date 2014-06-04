package andreasgrassl.src.main;

import java.awt.EventQueue;

import andreasgrassl.src.gui.Googling;


public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
		    public void run() {
		    	new Googling();
		    }
		});
		
	}
}