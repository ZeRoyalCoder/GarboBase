package me.newgarbo.garbobase.hooks;

import me.newgarbo.garbobase.GarboBase;
import me.newgarbo.garbobase.event.types.EventMotionUpdate;
import me.newgarbo.garbobase.event.utils.EventState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.world.World;

/**
 * Hook for the main player class (used for updating events and what-not).
 * 
 * @author NewGarbo
 */
public class HookPlayer extends EntityPlayerSP
{
	public HookPlayer(Minecraft mc, World world, NetHandlerPlayClient netHandler, StatFileWriter statWriter)
	{
		super(mc, world, netHandler, statWriter);
	}
	
	public void func_175161_p()
	{
		GarboBase.getInstance().eventManager.callEvent(new EventMotionUpdate(EventState.PRE));
		super.func_175161_p();
		GarboBase.getInstance().eventManager.callEvent(new EventMotionUpdate(EventState.POST));
	}
}
