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

//Gets the base specifications for the Login mod
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class LoginGUI {

	//Grabs references to each of the proxy sides, client and server. The proxy variable is decided when the project is running
	//depending on what side the user is on.
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static Proxy proxy;
	
	//Variables to hold the student's DYN username and password
	public static String DYN_Username = "";
	public static String DYN_Password = "";
	
	//Variables to hold the student's temporary username and password
	public static String Loan_Username = "";
	public static String Load_Password = "";

	//Variable for a logger (another way to debug)
	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Gets the logger for the preInit even in this class
		logger = event.getModLog();

		//The first line creates a variable called config. It contains data for the file "<base folder>\config\<your mod id>.cfg".
		//The second line loads the configuration file into memory.
		Configuration configs = new Configuration(event.getSuggestedConfigurationFile());
		try {
			configs.load();
		} catch (RuntimeException e) {
			//if it cannot load the config file log a warning
			logger.warn(e);
		}
		//Call the init function to move on (it will call whatever proxy.init() based on what side it is on
		proxy.init();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
