package messenger;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Client extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	public Client(String host){
		super("Andy's Instant Messenger Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					sendMessage(e.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		chatWindow.setEditable(false);
		setSize(300,150);
		setVisible(true);
	}
	
	public void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}
		catch(EOFException e1){
			showMessage("\nClient terminated connection");
		}
		catch(IOException e2){
			e2.printStackTrace();
		}
		finally{
			closeEverything();
		}
	}
	
	private void connectToServer() throws IOException{
		showMessage("\nAttempting connection...");
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("\nConnected to " + connection.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\nStreams are all setup.\n");
	}
	
	private void whileChatting() throws IOException{
		setAbleToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException e){
				showMessage("\n This should never happen");
			}
		}while(!message.equals("SERVER - END"));
	}
	
	private void closeEverything(){
		showMessage("\nClosing everything...");
		setAbleToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\nCLIENT - " + message);
		}
		catch(IOException e){
			chatWindow.append("\n Could not send message");
		}
	}
	
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				@Override
				public void run() {
					chatWindow.append(text);
				}
			}
		);
	}
	
	private void setAbleToType(final boolean tof){
		SwingUtilities.invokeLater(
			new Runnable(){
				@Override
				public void run() {
					userText.setEditable(tof);
				}
			}
		);
	}
}
