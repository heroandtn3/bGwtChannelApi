/**
 * 
 */
package com.google.gwt.channelapi.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author heroandtn3
 *
 */
@RemoteServiceRelativePath("gwtChannelService")
public interface GwtChannelService extends RemoteService {
	public String getToken(String clientId);
	public void sendMessage(String clientId, String message);
}
