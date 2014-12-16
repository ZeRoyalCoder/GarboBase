package me.newgarbo.garbobase;

import me.newgarbo.garbobase.module.ModManager;

/**
 * Main class for the GarboBase, extend this class or just use it as a global
 * API for accessing all the managers and so on.
 * <p>
 * If you do not extend it, then accessing it by simply calling the static
 * instance which is: {@code GarboBase.getInstance()}
 * <p>
 * Or, if you really want to, you can use reflection (you bad boy) and search
 * for private static instance which is: {@code GarboBase.instance}
 * 
 * @author NewGarbo
 * @version 1.0
 */
public class GarboBase
{
	/**
	 * The name of this client, used for logging and also any rendering in the
	 * main menu and other places. Change this to the name of the client that
	 * you are making.
	 */
	public static final String CLIENT_NAME = "GarboClient";
	
	/**
	 * The main instance of the {@link GarboBase}, initializing
	 * {@link GarboBase} manually, or if it is initialized more than once, many
	 * things may mess up including re-initialization of everything else, like
	 * most of the managers, and possibly some file overriding/deletion.
	 * Basically, a lot of unwanted and unexpected things will happen, so just
	 * don't initialize another instance.
	 */
	private static GarboBase instance;
	
	public ModManager modManager;
	
	static
	{
		instance = new GarboBase().startup();
	}
	
	/**
	 * Initializes the client and then returns an instance of GarboBase with all
	 * the fields and managers initialized for {@link GarboBase#instance} to be
	 * set to (set by the static block in {@link GarboBase}).
	 */
	public GarboBase startup()
	{
		long startupBeginTime = System.currentTimeMillis();
		System.out.println("[" + CLIENT_NAME + "] Starting up...");
		
		loadManagers();
		
		return this;
	}
	
	/**
	 * Loads all the managers (including the {@link ModManager}, CommandManager
	 * and other things like that.)
	 */
	private void loadManagers()
	{
		this.modManager = new ModManager();
	}
	
	/**
	 * Returns an instance of {@link GarboBase}, which is
	 * {@link GarboBase#instance}
	 */
	public static GarboBase getInstance()
	{
		return instance;
	}
}
