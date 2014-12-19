package me.newgarbo.garbobase.event;

import me.newgarbo.garbobase.event.base.TypeCancellable;

/**
 * An event that can be cancelled.
 * 
 * @author NewGarbo
 */
public abstract class EventCancellable implements Event, TypeCancellable
{
	protected boolean cancelled;
	
	@Override
	public void setCancelled(boolean flag)
	{
		this.cancelled = true;
	}
	
	@Override
	public boolean isCancelled()
	{
		return this.cancelled;
	}
}
