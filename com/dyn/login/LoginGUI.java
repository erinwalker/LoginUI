package com.dyn.login;

import org.apache.logging.log4j.Logger;
import com.dyn.login.proxy.Proxy;
import com.dyn.login.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
/**
 * @author Erin Walker
 * @version 1.0
 * @since 2016-02-23
 */

/**
 * Gets the base specifications for the Login mod.
 * @see com.gyn.login.reference.Reference
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class LoginGUI {
	/**
	 * Gets instance of proxy.
	 * The proxy variable is decided when the project is running
	 * depending on what side the user is on. Either client or server.
	 */
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static Proxy proxy;
	
	/**
	 * Holds DYN student username
	 */
	public static String DYN_Username = "";
	
	/**
	 * Holds DYN student password
	 */
	public static String DYN_Password = "";
	
	/**
	 * Holds loaned student username
	 */
	public static String Loan_Username = "";
	
	/**
	 * Holds loaned student password
	 */
	public static String Load_Password = "";

	/**
	 * The logger is another way to debug.
	 */
	public static Logger logger;

	/**
	 * This is the pre-initialization.
	 * It is attached to an EventHandler
	 * @param event Gets an instance of the preInit event
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		/**
		 * Sets the logger to the preInit event Mod log.
		 */
		logger = event.getModLog();
		
		/**
		 * Creates a variable called config.
		 * It contains data for the file "<base folder>\config\<your mod id>.cfg
		 */
		Configuration configs = new Configuration(event.getSuggestedConfigurationFile());
		/**
		 * Tries to load config file else logs a warning.
		 */
		try {
			/**
			 * Loads the configuration file into memory.
			 */
			configs.load();
		} catch (RuntimeException e) {
			logger.warn(e);
		}
		/**
		 * Calls the base init() method.
		 * It will call the relevant init() based on what side the user is on
		 */
		proxy.init();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
