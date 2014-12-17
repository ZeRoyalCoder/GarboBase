package me.newgarbo.garbobase.module.mods;

import java.awt.Color;

import me.newgarbo.garbobase.utils.Key;

public abstract class Module
{
	private String displayName;
	private String name;
	private boolean isEnabled;
	private Key keybind;
	private int color;
	
	public String getDisplayName()
	{
		return this.displayName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isEnabled()
	{
		return this.isEnabled;
	}
	
	public Key getBind()
	{
		return this.keybind;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public void toggle()
	{
		this.isEnabled = !this.isEnabled;
		
		onToggle();
		
		if (this.isEnabled)
		{
			onEnable();
		}
		else
		{
			onDisable();
		}
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public abstract void onToggle();
}
