package com.dyn.login.proxy;

import org.lwjgl.input.Keyboard;

import com.dyn.login.gui.Login;
import com.rabbit.gui.GuiFoundation;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

//Implements the proxy interface
public class Client implements Proxy {
	
	//Variable for Key Binding
	private KeyBinding loginKey;

	/**
	 * @see forge.reference.proxy.Proxy#renderGUI()
	 */
	//Renders gui when the loginKey is pressed
	@Override
	public void renderGUI() {
		// Render GUI when on call from client
	}

	//Sets what the loginKey to 'L'and registers it with the Client
	@Override
	public void init() {
		FMLCommonHandler.instance().bus().register(this);

		loginKey = new KeyBinding("key.toggle.logingui", Keyboard.KEY_L, "key.categories.toggle");

		ClientRegistry.registerKeyBinding(loginKey);

	}

	//Called when a key is pressed and opens the gui when loginKey is pressed
	//If the a GUIChat screen is already opne do not open the login Gui
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if ((Minecraft.getMinecraft().currentScreen instanceof GuiChat)) {
			return;
		}
		if (loginKey.getIsKeyPressed()) {
			GuiFoundation.proxy.display(new Login());
		}
	}
}