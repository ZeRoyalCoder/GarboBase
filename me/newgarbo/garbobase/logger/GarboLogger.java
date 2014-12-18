package me.newgarbo.garbobase.logger;

public class GarboLogger
{
	/**
	 * The name of the client to use when logging messages.
	 */
	public String clientName;
	
	private static final String LOGGING_FORMAT = "[{0}]: {1}";
	
	public GarboLogger(String client)
	{
		this.clientName = client;
	}
	
	public void log(String n){
		System.out.println(LOGGING_FORMAT);
	}
	
}
