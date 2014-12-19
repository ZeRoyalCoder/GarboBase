package me.newgarbo.garbobase.module;

import java.util.ArrayList;

import net.minecraft.client.model.ModelArmorStand;
import me.newgarbo.garbobase.module.mods.Module;

public class ModManager
{
	/**
	 * A list of all of the Modules that are registered with this Mod Manager /
	 * Client. Do not directly add to this ArrayList at any point after Runtime,
	 * or after main initialization to prevent any Memory Leaks and or events
	 * being called multiple times and other weird things.
	 */
	private ArrayList<Module> mods;
	
	/**
	 * A ArrayList of enabled mods, please use
	 * {@link ModManager#getEnabledMods()} instead of this because this will not
	 * be updated all the time, unless {@link ModManager#getEnabledMods()} is
	 * called. This is just used so that whenever you call
	 * {@link ModManager#getEnabledMods()}, it doesn't initialize a whole new
	 * ArrayList (just to increase performance).
	 */
	private ArrayList<Module> enabledMods;
	
	public ModManager()
	{
		this.mods = new ArrayList<Module>();
	}
	
	/**
	 * Registers the specified module by adding it to the
	 * {@link ModManager#mods} ArrayList.
	 */
	public void registerMod(Module mod)
	{
		this.mods.add(mod);
	}
	
	/**
	 * Returns an ArrayList of all of the currently enabled Modules.
	 */
	public ArrayList<Module> getEnabledMods()
	{
		for (Module mod : mods)
		{
			if (mod.isEnabled() && !mods.contains(mod))
			{
				mods.add(mod);
			}
			else if (mods.contains(mod))
			{
				mods.remove(mod);
			}
		}
		
		return this.enabledMods;
	}
	
	/**
	 * Returns a Module with the specified name / identifier.
	 * <p>
	 * Will return {@code null} if no Module is found with the specified name.
	 */
	public Module getModByName(String name)
	{
		for (Module mod : mods)
		{
			if (mod.getName().equals(name))
			{
				return mod;
			}
		}
		
		return null;
	}

	public ArrayList<Module> getRegisteredMods()
	{
		return this.mods;
	}
}
