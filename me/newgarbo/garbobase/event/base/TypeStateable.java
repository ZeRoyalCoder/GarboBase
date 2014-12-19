package me.newgarbo.garbobase.event.base;

import me.newgarbo.garbobase.event.utils.EventState;


/**
 * A type which can have a state (Pre, Post), you need your event to implement this if you want to be
 * able to be able to have Event States.
 * 
 * @author NewGarbo
 */
public interface TypeStateable
{
	public EventState getState();
}
