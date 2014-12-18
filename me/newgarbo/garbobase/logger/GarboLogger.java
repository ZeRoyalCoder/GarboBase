package me.newgarbo.garbobase.logger;

import me.newgarbo.garbobase.utils.StringUtils;

public class GarboLogger
{
	/**
	 * The name of the client to use when logging messages.
	 */
	public String clientName;
	
	/**
	 * The format to use when logging messages.
	 */
	private static final String LOGGING_FORMAT = "[{0}]: {1}";
	
	public GarboLogger(String client)
	{
		this.clientName = client;
	}
	
	/**
	 * Logs a message to the console ({@code System.out.println}) using the
	 * default prefix, which is {@code clientName}.
	 */
	public void log(String text)
	{
		System.out.println(StringUtils.format(LOGGING_FORMAT, clientName, text));
	}
	
	/**
	 * Logs a message to the console ({@code System.out.println}) using the
	 * second specified String as the prefix.
	 */
	public void log(String text, String pre)
	{
		System.out.println(StringUtils.format(LOGGING_FORMAT, pre, text));
	}
	
}
