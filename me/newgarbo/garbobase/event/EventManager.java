package me.newgarbo.garbobase.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import me.newgarbo.garbobase.GarboBase;
import me.newgarbo.garbobase.event.utils.EventHandler;
import me.newgarbo.garbobase.module.mods.Module;

public class EventManager
{
	/**
	 * An arraylist of all of the registered listeners, use
	 * {@code getRegisteredListeners()} to get these, or do
	 * {@code registerListener(Listener)} to register a listener.
	 */
	private ArrayList<Listener> registeredListeners;
	
	public EventManager()
	{
		this.registeredListeners = new ArrayList<Listener>();
	}
	
	public void callEvent(Event event)
	{
		for (Listener listener : registeredListeners)
		{
			for (Method method : listener.getClass().getMethods())
			{
				if (method.isAnnotationPresent(EventHandler.class) && method.getParameterTypes().length == 1 && method.getParameterTypes()[0].isAssignableFrom(event.getClass()))
				{
					try
					{
						method.invoke(listener, event);
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
	
	/**
	 * Registers the specified Listener.
	 */
	public void registerListener(Listener l)
	{
		this.registeredListeners.add(l);
	}
	
	/**
	 * Returns an ArrayList of the currently registered Listeners.
	 */
	public ArrayList<Listener> getRegisteredListeners()
	{
		return this.registeredListeners;
	}
}
