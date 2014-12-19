package me.newgarbo.garbobase.event;

import me.newgarbo.garbobase.event.base.TypeCancellable;
import me.newgarbo.garbobase.event.base.TypeStateable;
import me.newgarbo.garbobase.event.utils.EventState;

/**
 * An event that can have a state (Pre, Post).
 * <p>
 * The name for this isn't very nice, and it probably isn't a valid word in
 * English, but right now I can't think of a better name.
 * 
 * @author NewGarbo
 */
public class EventStateable extends EventCancellable implements TypeStateable, Event
{
	protected EventState state;
	
	@Override
	public EventState getState()
	{
		return this.state;
	}
}
