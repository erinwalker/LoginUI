package com.dyn.login.gui;

import com.dyn.login.LoginGUI;
import com.rabbit.gui.background.DefaultBackground;
import com.rabbit.gui.component.control.Button;
import com.rabbit.gui.component.control.TextBox;
import com.rabbit.gui.component.display.TextLabel;
import com.rabbit.gui.render.TextAlignment;
import com.rabbit.gui.show.Show;
/**
 * @author Erin Walker
 * @version 1.0
 * @since 2016-02-23
 */

/**
 * Class is used to login users.
 * Used for kids that do have their own Minecraft account at home.
 * This is a gui class which must extend the class Show which is provided by rabbit.gui.
 * It gives us an easy way to create gui on the fly.
 */
public class Login extends Show {

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
	public Login() {
		this.setBackground(new DefaultBackground());
		this.title = "City of Learning Login";
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
		this.registerComponent(new TextLabel((int) (this.width * .6), (int) (this.height * .05), this.width / 3, 20,
				"Loan Account Login", TextAlignment.CENTER));

		/**
		 * Button to take user to Loan account login.
		 * Attached is a click listener, when clicked it displays the checkout gui
		 */
		this.registerComponent(new Button((int) (this.width * .9), (int) (this.height * .04), 20, 15, ">>")
				.setClickListener(but -> this.getStage().display(new Checkout())));

		/**
		 * Text label
		 */
		this.registerComponent(new TextLabel(this.width / 6, (int) (this.height * .325), this.width / 3, 20,
				"City of Learning Login", TextAlignment.LEFT));
		
		/**
		 * Login Button
		 * Attached is a click listener, when clicked it attempts to login the user.
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
	 * Sets DYN_Username and DYN_Password to what the user typed into the text box.
	 * Also closes out all gui.
	 */
	public void loginPressed() {
		// this is where the http request should happen, should probably thread it
		
		//if the login is successful it should set the variables
		LoginGUI.DYN_Username = username;
		LoginGUI.DYN_Password = password;
		this.stage.close();
	}
}
