package net.frostcraftsman.gimmickery.GUI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.frostcraftsman.gimmickery.network.Gimmickery250Packet;
import net.frostcraftsman.gimmickery.proxy.GimmickeryClientProps;
import net.frostcraftsman.gimmickery.tileentity.CristalTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.tileentity.TileEntity;

public class CristalGUI extends GuiScreen {
	boolean isActive=false;
	private GuiButton Switch;
	private GuiTextField text;
	private int activedCristalNum;
	private TileEntity tile;
	
	@SideOnly(Side.CLIENT)
	public CristalGUI(int x,int y,int z){
		this.tile=Minecraft.getMinecraft().theWorld.getBlockTileEntity(x,y,z);
	}
	@SideOnly(Side.CLIENT)
	public CristalGUI(TileEntity t){
		this.tile=t;
	}
	public void initGui(){
		//获取对应的TileEntity，并通过其获得数据
		if(this.tile instanceof CristalTileEntity){
			CristalTileEntity tile=(CristalTileEntity) this.tile;
			this.isActive=tile.isActive;
			this.activedCristalNum=tile.getCristalNum();
		}else{
			return;
		}
		//声明GUI按钮控件，id为1，并加入按钮列表
		Switch=new GuiButton(1, this.width/2-25, this.height/2-10,50,20,getSwitchString());
		buttonList.add(Switch);
		//声明GUI文本框
		text=new GuiTextField(fontRenderer, this.width/2-50, this.height/2-50, 100, 20);
		//设置文本框内的文字
		text.setText(""+this.activedCristalNum);
	}
	public void drawScreen(int par1,int par2,float par3){
		//绘制默认GUI
		drawDefaultBackground();
		//绘制GUI背景
		GL11.glColor3f(1F, 1F, 1F);
		mc.renderEngine.bindTexture(GimmickeryClientProps.BACK_GROUND_PIC);
		this.drawTexturedModalRect(90, 0, 0, 0, 244, 576);
		this.text.drawTextBox();
		super.drawScreen(par1, par2, par3);
	}
	//更新文本框内文字
	public void updateScreen() {
		this.activedCristalNum=((CristalTileEntity) this.tile).getCristalNum();
		this.text.setText(""+this.activedCristalNum);
	}
	@Override
	protected void actionPerformed(GuiButton button){
		switch(button.id){
		case 1:
			//按下开关按钮的动作
			this.isActive=!this.isActive;
			((CristalTileEntity) this.tile).isActive=this.isActive;
			setTileEntityData(isActive);
			button.displayString=this.getSwitchString();
			//发送数据包
			Gimmickery250Packet pkt=new Gimmickery250Packet();
			pkt.packetType=0;
			pkt.dataInt=new int[]{this.tile.xCoord,this.tile.yCoord,this.tile.zCoord};
			pkt.dataBoolean=new boolean[]{this.isActive};
			PacketDispatcher.sendPacketToServer(pkt.toPacket());
			break;
		default:
			break;
		}
	}
	
	private String getSwitchString(){
		return this.isActive?"OFF":"ON";
	}
	private void setTileEntityData(boolean b){
		if(b){
			((CristalTileEntity) this.tile).CristalNumPlus1();
		}else{
			((CristalTileEntity) this.tile).CristalNumMinors1();
		}
	}
	public boolean doesGuiPauseGame()
    {
        return false;
    }
}
