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

public class Client implements Proxy {

	private KeyBinding loginKey;

	/**
	 * @see forge.reference.proxy.Proxy#renderGUI()
	 */
	@Override
	public void renderGUI() {
		// Render GUI when on call from client
	}

	@Override
	public void init() {
		FMLCommonHandler.instance().bus().register(this);

		loginKey = new KeyBinding("key.toggle.logingui", Keyboard.KEY_L, "key.categories.toggle");

		ClientRegistry.registerKeyBinding(loginKey);

	}

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