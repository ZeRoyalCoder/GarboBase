package me.newgarbo.garbobase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;

public class Wrapper
{
	/**
	 * Returns an instance of the Minecraft class.
	 */
	public static Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}
	
	/**
	 * Returns an instance of the main player class (in 1.7 this was named
	 * EntityClientPlayerMP, but in 1.8 it's EntityPlayerSP).
	 * <p>
	 * Note that this could be null at any time if the game is in the main menu,
	 * or if you are not logged in to any server / in a world.
	 */
	public static EntityPlayerSP getPlayer()
	{
		return getMinecraft().thePlayer;
	}
	
	/**
	 * Returns an instance of the world class.
	 * <p>
	 * Note that this could be null at any time if the game is in the main menu,
	 * or if you are not logged in to any server / in a world.
	 */
	public static WorldClient getWorld()
	{
		return getMinecraft().theWorld;
	}
}
