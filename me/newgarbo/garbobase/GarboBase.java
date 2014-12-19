package me.newgarbo.garbobase;

import me.newgarbo.garbobase.event.EventManager;
import me.newgarbo.garbobase.logger.GarboLogger;
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
public class GarboBase extends Wrapper
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
	
	/**
	 * The main Module Manager instance, do NOT instantiate another one of these
	 * classes or else a lot of errors and other unexpected things may occur.
	 */
	public ModManager modManager;
	
	/**
	 * The main Event Manager instance, do NOT instantiate another one of these
	 * classes or else a lot of errors and other unexpected things may occur.
	 */
	public EventManager eventManager;
	
	/**
	 * The main instance of the GarboLogger, this is instantiated in the startup
	 * method, which is used for any logging, to be able to log it and just to
	 * be able to change the logging format at any point.
	 */
	private GarboLogger logger;
	
	/**
	 * Initializes the client and then returns an instance of GarboBase with all
	 * the fields and managers initialized for {@link GarboBase#instance} to be
	 * set to (set by the static block in {@link GarboBase}).
	 */
	public static GarboBase startup()
	{
		GarboBase gb = new GarboBase();
		
		GarboBase.instance = gb;
		
		long startupBeginTime = System.currentTimeMillis();
		System.out.println("[" + CLIENT_NAME + "] Starting up...");
		
		gb.loadManagers();
		gb.loadHooks();
		
		gb.logger = new GarboLogger(CLIENT_NAME);
		
		return gb;
	}
	
	/**
	 * Loads all of the hooks and then uses them.
	 */
	private void loadHooks()
	{
	}
	
	/**
	 * Gets run every tick.
	 */
	public void onTick()
	{
		
	}
	
	/**
	 * Loads all the managers (including the {@link ModManager}, CommandManager
	 * and other things like that.)
	 */
	private void loadManagers()
	{
		this.modManager = new ModManager();
		this.eventManager = new EventManager();
		
		this.loadMods();
	}
	
	/**
	 * Loads all of the Modules to the Module Manager.
	 * <p>
	 * You need to add your modules here manually, example:
	 * <p>
	 * Add another line of code in here just like the one that is already in
	 * there, example, adding a Flight mod would be like this:
	 * <p>
	 * {@code this.modManager.registerMod(new Flight());}
	 * <p>
	 * For more information, go to the main Hackforums thread, which will
	 * contain very in-depth usage.
	 */
	private void loadMods()
	{
		// this.modManager.registerMod(new MyModule());
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
