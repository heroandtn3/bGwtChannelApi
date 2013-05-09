/*
 * Copyright 2013 heroandtn3 (heroandtn3 [at] gmail.com) 
 * 
 * This file is part of GwtChannelApi.
 * GwtChannelApi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * GwtChannelApi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with GwtChannelApi.  If not, see <http://www.gnu.org/licenses/>.
 */

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
