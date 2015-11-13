package com.dyn.login.gui;

import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.Unpooled;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import org.lwjgl.opengl.GL11;

public class GuiCcolLogin extends GuiScreen {
	private static final ResourceLocation texture = new ResourceLocation("login",
			"textures/gui/loginTex.png");
	public int mouseX;
	public int mouseY;
	public static final int GUI_ID = 11;

	public GuiCcolLogin() {
		
	}

	public void initGui() {
		this.buttonList.clear();
		int i1 = (this.width - this.xSize) / 2;
		int j1 = (this.height - this.ySize) / 4;
		this.buttonList.add(new GuiButton(1, i1 - 52, j1 + 18, 50, 20, "Login"));
		this.buttonList.add(new GuiButton(2, i1 - 52, j1 + 43, 50, 20, "Cancel"));
	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 1:
			this.mc.displayGuiScreen(null);
			break;
		}
	}

	protected void mouseClicked(int i, int j, int k) {
		super.mouseClicked(i, j, k);
	
	}

	protected void mouseMovedOrUp(int i, int j, int k) {
		super.mouseMovedOrUp(i, j, k);

		this.mouseX = i;
		this.mouseY = j;
	}

	public void drawScreen(int i, int j, float f) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		/*int i1 = (this.width - this.xSize) / 2;
		int j1 = (this.height - this.ySize) / 4;
		drawTexturedModalRect(i1, j1, 0, 0, this.xSize, this.ySize);
		int i2 = 5;
		int j2 = 5;
		for (int l1 = 0; l1 < this.yLength; l1++) {
			for (int l2 = 0; l2 < this.xLength; l2++) {
				boolean flag = false;
				for (int l3 = 0; l3 < 17; l3++) {
					if (this.blocks[this.currentLayer][l1][l2] == l3) {
						drawTexturedModalRect(i1 + i2 + l2 * this.colorSize, j1 + j2 + l1 * this.colorSize,
								this.colorSize * l3, this.ySize + 10, this.colorSize, this.colorSize);
						flag = true;
					}
					if ((!flag) && (this.currentLayer > 0) && (this.blocks[(this.currentLayer - 1)][l1][l2] == l3)) {
						drawTexturedModalRect(i1 + i2 + l2 * this.colorSize, j1 + j2 + l1 * this.colorSize,
								this.colorSize * l3, this.ySize + 15, this.colorSize, this.colorSize);
					}
				}
			}
		}
		for (int l1 = 0; l1 < this.yLength; l1++) {
			for (int l2 = 0; l2 < this.xLength; l2++) {
				if ((this.drawingOptions == 0) && (this.mouseX >= i1 + i2 + l2 * this.colorSize)
						&& (this.mouseX < i1 + i2 + this.colorSize + l2 * this.colorSize)
						&& (this.mouseY >= j1 + j2 + l1 * this.colorSize)
						&& (this.mouseY < j1 + j2 + this.colorSize + l1 * this.colorSize)) {
					for (int l3 = -this.brushSize + 1; l3 < this.brushSize; l3++) {
						for (int l4 = -this.brushSize + 1; l4 < this.brushSize; l4++) {
							if ((l2 + l4 >= 0) && (l2 + l4 < this.xLength) && (l1 + l3 >= 0)
									&& (l1 + l3 < this.yLength)) {
								drawTexturedModalRect(i1 + i2 + l2 * this.colorSize + l4 * this.colorSize,
										j1 + j2 + l1 * this.colorSize + l3 * this.colorSize,
										this.color * this.colorSize, this.ySize + 10, this.colorSize, this.colorSize);
								drawTexturedModalRect(i1 + i2 + l2 * this.colorSize + l4 * this.colorSize,
										j1 + j2 + l1 * this.colorSize + l3 * this.colorSize, this.colorSize * 16,
										this.ySize + 10, this.colorSize, this.colorSize);
							}
						}
					}
				} else if ((this.drawingOptions == 3) && (this.mouseX >= i1 + i2 + l2 * this.colorSize)
						&& (this.mouseX < i1 + i2 + this.colorSize + l2 * this.colorSize)
						&& (this.mouseY >= j1 + j2 + l1 * this.colorSize)
						&& (this.mouseY < j1 + j2 + this.colorSize + l1 * this.colorSize)) {
					if (l1 >= this.linePosY) {
						if (l2 >= this.linePosX) {
							for (int l3 = 0; l3 < l1 - this.linePosY + 1; l3++) {
								for (int l4 = 0; l4 < l2 - this.linePosX + 1; l4++) {
									drawTexturedModalRect(
											i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
											j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
											this.color * this.colorSize, this.ySize + 10, this.colorSize,
											this.colorSize);
									drawTexturedModalRect(
											i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
											j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
											this.colorSize * 16, this.ySize + 10, this.colorSize, this.colorSize);
								}
							}
						} else {
							for (int l3 = 0; l3 < l1 - this.linePosY + 1; l3++) {
								for (int l4 = 0; l4 > l2 - this.linePosX - 1; l4--) {
									drawTexturedModalRect(
											i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
											j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
											this.color * this.colorSize, this.ySize + 10, this.colorSize,
											this.colorSize);
									drawTexturedModalRect(
											i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
											j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
											this.colorSize * 16, this.ySize + 10, this.colorSize, this.colorSize);
								}
							}
						}
					} else if (l2 >= this.linePosX) {
						for (int l3 = 0; l3 > l1 - this.linePosY - 1; l3--) {
							for (int l4 = 0; l4 < l2 - this.linePosX + 1; l4++) {
								drawTexturedModalRect(i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
										j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
										this.color * this.colorSize, this.ySize + 10, this.colorSize, this.colorSize);
								drawTexturedModalRect(i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
										j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
										this.colorSize * 16, this.ySize + 10, this.colorSize, this.colorSize);
							}
						}
					} else {
						for (int l3 = 0; l3 > l1 - this.linePosY - 1; l3--) {
							for (int l4 = 0; l4 > l2 - this.linePosX - 1; l4--) {
								drawTexturedModalRect(i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
										j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
										this.color * this.colorSize, this.ySize + 10, this.colorSize, this.colorSize);
								drawTexturedModalRect(i1 + i2 + this.linePosX * this.colorSize + l4 * this.colorSize,
										j1 + j2 + this.linePosY * this.colorSize + l3 * this.colorSize,
										this.colorSize * 16, this.ySize + 10, this.colorSize, this.colorSize);
							}
						}
					}
				}
			}
		}
		drawTexturedModalRect(i1 + this.xSize + 5, j1, this.xSize, 0, this.xSize2, this.ySize2);
		for (int k = 0; k < 17; k++) {
			drawTexturedModalRect(i1 + this.xSize + 13, j1 + 35 + k * 11, k * 10, this.ySize, 10, 10);
		}
		if (this.color == 16) {
			drawTexturedModalRect(i1 + this.xSize + 13, j1 + 8, 0, this.ySize, 10, 10);
		} else {
			drawTexturedModalRect(i1 + this.xSize + 13, j1 + 8, 10 + 10 * this.color, this.ySize, 10, 10);
		}
		drawTexturedModalRect(i1 - 55, j1 + 89, this.xSize - 56, this.ySize, 56, 22);
		drawTexturedModalRect(i1 - 55, j1 + 111, this.xSize - 56, this.ySize + 4, 56, 15);
		drawTexturedModalRect(i1 - 55, j1 + 126, this.xSize - 56, this.ySize + 4, 56, 22);

		drawTexturedModalRect(i1 - 55, j1 + 150, this.xSize - 56, this.ySize, 56, 22);
		drawTexturedModalRect(i1 - 55, j1 + 172, this.xSize - 56, this.ySize + 4, 56, 15);
		drawTexturedModalRect(i1 - 55, j1 + 187, this.xSize - 56, this.ySize + 4, 56, 18);
		drawTexturedModalRect(i1 - 55, j1 + 205, this.xSize - 56, this.ySize + 4, 56, 22);
		drawTexturedModalRect(i1 - 40, j1 + 164, this.xSize, this.ySize, 26, 18);

		//commented out functions throw an error
		//this.fontRendererObj.drawString(this.brushSize, i1 + this.xSize + 15, j1 + 20, 1052688);
		this.fontRendererObj.drawString("Brush", i1 - 41, j1 + 96, 1052688);
		this.fontRendererObj.drawString("Size", i1 - 38, j1 + 106, 1052688);
		//this.fontRendererObj.drawString(this.currentLayer, i1 - 33, j1 + 168, 1052688);
		this.fontRendererObj.drawString("Layer", i1 - 41, j1 + 155, 1052688);*/
		super.drawScreen(i, j, f);
	}

	protected void keyTyped(char c, int i) {
		super.keyTyped(c, i);
		//does this only trigger when the gui is opened
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	public int xSize = 230;
	public int ySize = 230;
	public int xSize2 = 26;
	public int ySize2 = 230;
	
}
