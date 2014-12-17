package me.newgarbo.garbobase.module;

import java.util.ArrayList;

import me.newgarbo.garbobase.module.mods.Module;

public class ModManager
{
	public ArrayList<Module> mods;
	
	public ModManager()
	{
		this.mods = new ArrayList<Module>();
	}
	
	public void registerMod(Module mod)
	{
		this.mods.add(mod);
	}
	
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
}
