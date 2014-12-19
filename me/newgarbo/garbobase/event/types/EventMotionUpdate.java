package me.newgarbo.garbobase.event.types;

import me.newgarbo.garbobase.event.EventStateable;
import me.newgarbo.garbobase.event.utils.EventState;
import net.minecraft.util.AxisAlignedBB;

public class EventMotionUpdate extends EventStateable
{
	public EventMotionUpdate(EventState state)
	{
		this.state = state;
	}
}
