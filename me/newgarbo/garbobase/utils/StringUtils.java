package me.newgarbo.garbobase.utils;

public class StringUtils
{
	public static String format(String text, String ... args){
		for (int i = 0; i < args.length; i++){
			text = text.replace("{" + i + "}", args[i]);
		}
		
		return text;
	}
}
