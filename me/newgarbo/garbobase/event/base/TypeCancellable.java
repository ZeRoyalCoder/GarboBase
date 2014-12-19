package me.newgarbo.garbobase.event.base;

/**
 * A cancellable type, you need your event to implement this if you want to be
 * able to cancel it.
 * 
 * @author NewGarbo
 */
public interface TypeCancellable
{
	public void setCancelled(boolean flag);
	public boolean isCancelled();
}
