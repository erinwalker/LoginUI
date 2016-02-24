package com.dyn.login.gui;

import com.dyn.login.LoginGUI;
import com.rabbit.gui.background.DefaultBackground;
import com.rabbit.gui.component.control.Button;
import com.rabbit.gui.component.control.TextBox;
import com.rabbit.gui.component.display.TextLabel;
import com.rabbit.gui.render.TextAlignment;
import com.rabbit.gui.show.Show;
/**
 * @author Dominic Amato
 * @version 1.0
 * @since 2016-02-23
 */

/**
 * Class is used for checking out usernames and passwords.
 * <p>
 * Used for kids that do not have a Minecraft account at home.
 * This is a gui class which must extend the class Show which is provided by rabbit.gui.
 * It gives us an easy way to create gui on the fly.
 * </p>
 */
public class Checkout extends Show {

	/**
	 * Saves the username the user types in.
	 */
	private String username;
	
	/**
	 * Saves the password the user types in.
	 */
	private String password;

	/**
	 * Constructor for setting up the basic gui components.
	 */
	public Checkout() {
		this.setBackground(new DefaultBackground());
		this.title = "Account Checkout Login";
	}

	/**
	 * Override for base setup() method.
	 * Must call super.setup().
	 * Sets up buttons, text labels, and text boxes for gui.
	 */
	@Override
	public void setup() {
		super.setup();

		/**
		 * Text label
		 */
		this.registerComponent(new TextLabel((int) (this.width * .59), (int) (this.height * .05), this.width / 3, 20,
				"City of Learning Login", TextAlignment.CENTER));
		
		/**
		 * Back Button.
		 * Attached is a click listener and when clicked displays the previous gui on screen 
		 */
		this.registerComponent(new Button((int) (this.width * .9), (int) (this.height * .04), 20, 15, "<<")
				.setClickListener(but -> this.getStage().displayPrevious()));
		
		/**
		 * Text label
		 */
		this.registerComponent(new TextLabel(this.width / 6, (int) (this.height * .325), this.width / 3, 20,
				"Loan Account Login", TextAlignment.LEFT));

		/**
		 * Login Button.
		 * Attached is a click listener and when clicked attempts to login user. 
		 */
		this.registerComponent(new Button((int) (this.width * .7), (int) (this.height * .55), 50, 20, "Login")
				.setClickListener(but -> loginPressed()));
		/**
		 * Text box for username
		 */
		this.registerComponent(new TextBox((int) (this.width * .15), (int) (this.height * .4), 200, 20, "username")
				.setTextChangedListener((TextBox textbox, String previousText) -> textChanged(textbox, previousText))
				.setId("username"));
		/**
		 * Text box for password
		 */
		this.registerComponent(new TextBox((int) (this.width * .15), (int) (this.height * .55), 200, 20, "password")
				.setTextChangedListener((TextBox textbox, String previousText) -> textChanged(textbox, previousText))
				.setId("password"));
	}
	/**
	 * Checks if the text that the user typed in changed from their last entry.
	 * If the text box matches one of the gui text boxes set the text to what was typed previously.
	 * This is so the user can see if he/she made mistakes.
	 * @param textbox Reference to the relevant text box in use
	 * @param previousText Saves the last text typed into the box
	 */
	public void textChanged(TextBox textbox, String previousText) {
		if (textbox.getId() == "username") {
			username = previousText;
		} else if (textbox.getId() == "password") {
			password = previousText;
		}
	}

	/**
	 * Method called when the login button is pressed.
	 * Sets Loan_Username and Loan_Password to what the user typed into the text box.
	 */
	public void loginPressed() {
		// this is where the http request should happen, should probably thread it
		
		//if the login is successful it should set the variables
		LoginGUI.Loan_Username = username;
		LoginGUI.Load_Password = password;
	}
}
