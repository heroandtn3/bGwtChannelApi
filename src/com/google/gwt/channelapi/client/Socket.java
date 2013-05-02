/**
 * 
 */
package com.google.gwt.channelapi.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author heroandtn3
 *
 */
public class Socket extends JavaScriptObject {

	/**
	 * 
	 */
	protected Socket() {
		
	}
	
	public final native void close() /*-{
		this.close();
	}-*/;

}
