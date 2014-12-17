package me.newgarbo.garbobase.module.mods;

import java.awt.Color;

import me.newgarbo.garbobase.utils.Key;

public abstract class Module
{
	/**
	 * The string that will be displayed in the ArrayList when this Module is
	 * enabled. Will be {@code null} if this module is not rendered in the
	 * ArrayList.
	 */
	private String displayName;
	
	/**
	 * The internal name / identifier of this module (has to be unique from any
	 * other Modules so that there is a way to identify this Module as a
	 * seperate one from others.
	 */
	private String name;
	
	/**
	 * Whether or not this Module is enabled, pretty self explanatory.
	 */
	private boolean isEnabled;
	
	/**
	 * The Key instance which defines the Keybind for this Module, will be null
	 * if this Module is not toggleable through Keybinds.
	 */
	private Key keybind;
	
	/**
	 * The color that this module will be rendered as in the ArrayList. Will be
	 * {@code -1} if this Module is not rendered in the ArrayList.
	 */
	private int color;
	
	/**
	 * Returns the {@link Module#displayName}
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}
	
	/**
	 * Returns the {@link Module#name}
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns {@link Module#isEnabled}
	 */
	public boolean isEnabled()
	{
		return this.isEnabled;
	}
	
	/**
	 * Returns the {@link Module#keybind}
	 */
	public Key getBind()
	{
		return this.keybind;
	}
	
	/**
	 * Returns the {@link Module#color}
	 */
	public int getColor()
	{
		return this.color;
	}
	
	/**
	 * Toggles this module, calls {@code onToggle()} and then calls
	 * {@code onEnable()} or {@code onDisable()} accordingly.
	 */
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
