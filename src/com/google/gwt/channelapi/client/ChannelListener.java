/**
 * 
 */
package com.google.gwt.channelapi.client;

/**
 * @author heroandtn3
 *
 */
public interface ChannelListener {
	public void onOpen();
	public void onMessage(String message);
	public void onClose();
	public void onError(int code, String description);
	
}
