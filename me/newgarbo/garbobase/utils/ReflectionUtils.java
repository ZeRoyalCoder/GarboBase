package me.newgarbo.garbobase.utils;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.stats.StatFileWriter;

public class ReflectionUtils
{
	public static Object getField(Object obj, String var)
	{
		try
		{
			return obj.getClass().getDeclaredField(var).get(obj);
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}
