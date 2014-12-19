package me.newgarbo.garbobase.utils;

import java.lang.reflect.Field;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.stats.StatFileWriter;

public class ReflectionUtils
{
	public static Object getField(Object obj, String var)
	{
		try
		{
			Field f = obj.getClass().getDeclaredField(var);
			Object returnObj = null;
			
			f.setAccessible(true);
			
			returnObj = f.get(obj);
			
			f.setAccessible(false);
			
			return returnObj;
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
