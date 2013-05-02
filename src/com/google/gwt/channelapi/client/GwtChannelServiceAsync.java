/**
 * 
 */
package com.google.gwt.channelapi.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author heroandtn3
 *
 */
public interface GwtChannelServiceAsync {

	void getToken(String clientId, AsyncCallback<String> callback);

	void sendMessage(String clientId, String message, AsyncCallback<Void> callback);

}
