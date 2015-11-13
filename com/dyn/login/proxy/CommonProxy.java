package com.dyn.login.proxy;

import com.dyn.login.config.ConfigHandler;
import com.dyn.login.gui.GuiCcolLogin;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler {

	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GuiCcolLogin.GUI_ID)
			return new GuiCcolLogin();

		return null;
	}
	
	public void openGUI(EntityPlayer player) {
		FMLClientHandler.instance().displayGuiScreen(player, new GuiCcolLogin());
	}
	
}
