import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * A class that validates user input, used as part of an input form
 */
public class ValidateForm
{
	public ValidateForm() {
		//no variables to initialize
	}

    public boolean isAllAlpha(String str){
        boolean isAlpha = true;
        for(int i = 0; i < str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                isAlpha = false; // if every character is not a letter, return false
            }
			else{
				isAlpha = true;
			}
        }
        return isAlpha;
    }

    public boolean isNumeric(String str){
        boolean isNumeric = true;
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                isNumeric = false;
            }
			else{
				isNumeric = true;
			}
        }
        return isNumeric;
    }

	/** validate the user's entered name */
	public String checkName(String name) {
        String error = "";
        if(name.length() < 2 && !isAllAlpha(name)){
            error =  "Invalid name!\n";
        }
        else if (name.length() >= 2 && isAllAlpha(name)){
            error = "";
        }
        return error;
	}

	/** validate the user's entered email */
	public String checkEmail(String email) {
        String validate = "";
        if(!email.contains("@") && !email.contains(".")){ // if . and @ don't exist in email throw an error
            validate = "Invalid email!";
        }
		else{ // couple more checks to see other criteria if email is valid
			if (email.indexOf(".") > email.indexOf("@")){ // dot comes after @ ?
				validate = "Valid email!";
			}
			else if (email.indexOf("@") > 0 && email.indexOf(".") > email.indexOf("@") + 1){
				validate = "Valid email!";
			}
		}
        return validate;
	}

	/** validate the user's enter password */
	public String checkPW(String pw) {
        if (pw.length() < 4) {
            return "Password must be at least 4 characters.";
        }
        else if (!pw.matches(".*[0-9].*")) { // using regex to check if number is contained in password
            return "Password must contain at least 1 number.";
        }
        else if (!pw.matches(".*[a-z].*")) { // check if lower case letters exist in password
            return "Password must contain at least 1 lower case letter.";
        }
        else if (!pw.matches(".*[A-Z].*")) { // check if uppercase letters exist in password
            return "Password must contain at least 1 upper case letter.";
        }
        else {
            return "";
        }
	}

	/** validate the user's entered zipcode */
	public String checkZip(String zip) {
        if (zip.length() > 3 && zip.length() < 5 && isNumeric(zip)){
			return "";
		}
		else {
			return "Invalid zip code!";
		}
		}

	/** validate the user's entered birth year */
	public String checkBirth(String date) {
        int year = 0;
        try {
            year = Integer.parseInt(date);
        } catch (NumberFormatException ex) {
            return "Invalid birth year!";
        }
        if (year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            return "Invalid birth year!"; // year needs to be between 1900 and the present year for it to be considered valid
        }
        else {
            return "";
        }
	}

	/** validate the user's entered phone number */
	public String checkPhone(String phone) {
		String newPhone = phone.replace("-", "");
		if (newPhone.length() == 10 && isNumeric(newPhone)) {
			return "";
		}
		else {
			return "Invalid phone number!";
		}
	}

	/** main method for testing / setting up the GUI */
	public static void main(String[] args)
	{
		//set up the GUI, you don't need to understand this code
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//the frame is the GUI, it uses a ValidateForm object
				TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A frame (GUI) with simple text components to simulate a web form
 */
class TextComponentFrame extends JFrame 
{
	static final int DEFAULT_WIDTH  = 300;
	static final int DEFAULT_HEIGHT = 400;

	ValidateForm validater;

	public TextComponentFrame(ValidateForm v)
	{
		validater = v;

		initGUI();
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null); //center on screen
	}

	/** initialize the GUI components, e.g. buttons and text fields */
	private void initGUI()
	{
		setTitle("Subscription Form");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		final JTextField personName = new JTextField();
		final JTextField emailField = new JTextField();
		final JTextField zipCode    = new JTextField();
		final JTextField birthDate  = new JTextField();

		MaskFormatter mfor = null;
		try {
			mfor = new MaskFormatter("###-###-####"); //for the phone number field
		}
		catch (ParseException e) {}

		final JFormattedTextField phoneNumber   = new JFormattedTextField(mfor);
		final JPasswordField      passwordField = new JPasswordField();

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
		northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
		northPanel.add(personName);
		northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
		northPanel.add(emailField);
		northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
		northPanel.add(zipCode);
		northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
		northPanel.add(birthDate);
		northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
		northPanel.add(phoneNumber);

		add(northPanel, BorderLayout.NORTH);

		final JTextArea textArea = new JTextArea(8, 40);
		JScrollPane scrollPane   = new JScrollPane(textArea);

		add(scrollPane, BorderLayout.CENTER);

		// add button to listen for events, append text into the text area

		JPanel  southPanel   = new JPanel();
		JButton submitButton = new JButton("Submit");
		southPanel.add(submitButton);
		submitButton.addActionListener(new ActionListener() //make anonymous action listener
		{
			/** this method is called in response to an event, in this case the "Submit" button pressed */
			public void actionPerformed(ActionEvent event)
			{
				String name     = personName.getText() ;
				String email    = emailField.getText();
				String zip      = zipCode.getText();
				String birth    = birthDate.getText();
				String phone    = phoneNumber.getText(); 
				String password = new String(passwordField.getPassword());

				String result = ""; 

				result += validater.checkName(name);
				result += validater.checkPW(password);
				result += validater.checkEmail(email);
				result += validater.checkZip(zip);
				result += validater.checkBirth(birth);
				result += validater.checkPhone(phone);

				if (result.length() == 0)
					result = "Input accepted!";

				textArea.setText(result);
			}
		});

		add(southPanel, BorderLayout.SOUTH);
	}
}
