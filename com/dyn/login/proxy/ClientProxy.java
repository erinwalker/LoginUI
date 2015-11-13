package com.dyn.login.proxy;

import com.dyn.login.config.ConfigHandler;
import com.dyn.login.gui.GuiCcolLogin;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        // Load configuration settings
        ConfigHandler.init(event.getSuggestedConfigurationFile());
       /* UpdateChecker checker = new UpdateChecker();
        checker.init();*/
    }
	
	public void load() {

	}

	public void openGUI(EntityPlayer player) {
		super.openGUI(player);
	}
	
	/*public void openGUI(EntityPlayer player, World world, int x, int y, int z, int meta, int dir) {
		FMLClientHandler.instance().displayGuiScreen(player, new GuiCcolLogin(world, x, y, z, meta, dir));
	}*/
}
