package me.newgarbo.garbobase.event.utils;

public enum EventPriority
{
	LOWEST(0),
	LOW(1),
	NORMAL(2),
	HIGH(3),
	HIGHEST(4);
	
	public final int id;
	
	EventPriority(int id)
	{
		this.id = id;
	}
}
