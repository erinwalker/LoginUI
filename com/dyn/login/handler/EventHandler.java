package com.dyn.login.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBufInputStream;
import java.io.IOException;

import com.dyn.login.LoginGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventHandler {
	 @SubscribeEvent
	  public void onKeyInput(InputEvent.KeyInputEvent event)
	  {
	    if ((Minecraft.getMinecraft().currentScreen instanceof GuiChat)) {
	      return;
	    }
	    if (LoginGUI.loginKey.getIsKeyPressed())
	    {
	      //this is where we toggle the gui screen and make the requests?
	    	//we need to get the player
			LoginGUI.proxy.openGUI(LoginGUI.tplayer);
	    	/*new ThreadUpdateChecker();
	        FMLCommonHandler.instance().bus().register(this);*/
	    }
	  }
}
