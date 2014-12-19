package me.newgarbo.garbobase.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import me.newgarbo.garbobase.GarboBase;
import me.newgarbo.garbobase.event.utils.EventHandler;
import me.newgarbo.garbobase.module.mods.Module;

public class EventManager
{
	public void callEvent(Event event)
	{
		for (Module mod : GarboBase.getInstance().modManager.getRegisteredMods())
		{
			for (Method method : mod.getClass().getMethods())
			{
				if (method.isAnnotationPresent(EventHandler.class) && method.getParameterTypes().length == 1 && method.getParameterTypes()[0].isAssignableFrom(event.getClass()))
				{
					try
					{
						method.invoke(mod, event);
					}
					catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
					catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
					catch (InvocationTargetException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}
