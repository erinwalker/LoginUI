package com.dyn.login.gui;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

import com.dyn.login.config.ConfigHandler;

import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiFactory implements IModGuiFactory {
	public void initialize(Minecraft minecraftInstance) {
	}

	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return GuiModConfig.class;
	}

	public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
		return null;
	}

	public static class GuiModConfig extends GuiConfig {

		public GuiModConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID,
				boolean allRequireWorldRestart, boolean allRequireMcRestart, String title) {
			super(parentScreen, configElements, modID, allRequireWorldRestart, allRequireMcRestart, title);
			// TODO Auto-generated constructor stub
		}
	}
}
