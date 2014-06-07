package src.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import src.listeners.JTextAreaListener;

public class Googling extends JFrame {

	private static final long serialVersionUID = 1L;
	private HashMap<String,JPanel> panelMap;
	private HashMap<String,JButton> buttonMap;
	private HashMap<String,JTextArea> textAreaMap;
	private ArrayList<String> buttonNameList;
	private ArrayList<String> panelNameList;
	private ArrayList<String> textAreaNameList;
	
	public Googling(){
		panelMap = new HashMap<String,JPanel>();
		buttonMap = new HashMap<String,JButton>();
		textAreaMap = new HashMap<String,JTextArea>();
		buttonNameList = new ArrayList<String>();
		panelNameList = new ArrayList<String>();
		textAreaNameList = new ArrayList<String>();

		initFrame();
	}
	
	/*
	 * Init the frame for googling stuff from Desktop
	 */
	private void initFrame(){
		
		/*
		 * change addPanels(), addButtons() and addTextFields() if Layout is changed
		 */
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("DesktopTools");
		
		this.addPanels();
		this.addButtons();
		this.addTextAreas();
		
		this.setPreferredSize(new Dimension(400,50));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	/*
	 * Panels are added for BorderLayout. Change if necessary
	 */
	private void addPanels(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		this.add(centerPanel,BorderLayout.CENTER);
		this.panelMap.put("centerPanel", centerPanel);
		this.panelNameList.add("centerPanel");
	}
	
	/*
	 * TextFields are added for BorderLayout. Change if necessary
	 */
	private void addTextAreas(){
		JTextArea googleRequestArea = new JTextArea();
		getPanelByName("centerPanel").add(googleRequestArea,BorderLayout.CENTER);
		this.getTextAreaMap().put("googleRequestArea", googleRequestArea);
		this.getTextAreaNameList().add("googleRequestArea");
		new JTextAreaListener(googleRequestArea);
	}
	
	/*
	 * Buttons are added for BorderLayout. Change if necessary
	 */
	private void addButtons(){
		
	}

	public HashMap<String,JButton> getButtonMap() {
		return buttonMap;
	}

	public HashMap<String,JPanel> getPanelMap() {
		return panelMap;
	}

	public ArrayList<String> getButtonNameList() {
		return buttonNameList;
	}
	
	public ArrayList<String> getPanelNameList() {
		return panelNameList;
	}
	
	public JPanel getPanelByName(String s){
		return this.getPanelMap().get(s);
	}
	
	public JButton getButtonByName(String s){
		return this.getButtonMap().get(s);
	}
	
	public JTextArea getTextAreaByName(String s){
		return this.getTextAreaMap().get(s);
	}

	public ArrayList<String> getTextAreaNameList() {
		return textAreaNameList;
	}

	public HashMap<String,JTextArea> getTextAreaMap() {
		return textAreaMap;
	}
}