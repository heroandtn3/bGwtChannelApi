/**
 * 
 */
package com.google.gwt.channelapi.server;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gwt.channelapi.shared.GwtChannelService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author heroandtn3
 * 
 */
public class GwtChannelServiceImpl extends RemoteServiceServlet implements
		GwtChannelService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChannelService channelService;
	/**
	 * 
	 */
	public GwtChannelServiceImpl() {
		channelService = ChannelServiceFactory.getChannelService();
	}

	@Override
	public String getToken(String clientId) {
		return channelService.createChannel(clientId);
	}

	@Override
	public void sendMessage(String clientId, String message) {
		channelService.sendMessage(new ChannelMessage(clientId, message));
	}

}
