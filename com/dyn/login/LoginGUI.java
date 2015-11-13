package com.dyn.login;

import org.lwjgl.input.Keyboard;

import com.dyn.login.handler.EventHandler;
import com.dyn.login.proxy.CommonProxy;
import com.dyn.login.reference.Reference;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class LoginGUI {

	public static FMLEventChannel channel;
	public static KeyBinding loginKey;
	public static EntityPlayer tplayer = FMLClientHandler.instance().getClient().thePlayer;;
	
	@Mod.Instance(Reference.MOD_ID)
	public static LoginGUI instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		
		FMLCommonHandler.instance().bus().register(new EventHandler());
		
		this.loginKey = new KeyBinding("key.toggle.loginGui", Keyboard.KEY_L, "key.categories.toggle");
	    
	    ClientRegistry.registerKeyBinding(this.loginKey);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent evt) {

	}

	@Mod.EventHandler
	public void modsLoaded(FMLPostInitializationEvent evt) {
	}

	@Mod.EventHandler
	public void serverStarted(FMLServerStartedEvent event) {
	}
	
}
