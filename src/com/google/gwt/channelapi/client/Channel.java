/*
 * Copyright 2013 heroandtn3 (heroandtn3 [at] gmail.com) 
 * 
 * This file is part of bGwtChannelApi.
 * bGwtChannelApi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * bGwtChannelApi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with bGwtChannelApi.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * 
 */
package com.google.gwt.channelapi.client;

import com.google.gwt.channelapi.shared.GwtChannelService;
import com.google.gwt.channelapi.shared.GwtChannelServiceAsync;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author heroandtn3
 * 
 */
public class Channel {

	private ChannelListener channelListener;
	private GwtChannelServiceAsync gwtChannelService = GWT
			.create(GwtChannelService.class);
	private String clientId;
	private Socket socket;

	/**
	 * 
	 */
	public Channel(String clientId) {
		this.clientId = clientId;
	}

	public void sendMessage(String clientId, String message) {
		gwtChannelService.sendMessage(clientId, message,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
					}

					@Override
					public void onSuccess(Void result) {
					}
				});
	}

	public void join(ChannelListener channelListener) {
		this.channelListener = channelListener;
		if (channelListener == null)
			throw new NullPointerException();
		gwtChannelService.getToken(clientId, new AsyncCallback<String>() {

			@Override
			public void onSuccess(String token) {
				joinChannel(token);
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	public void close() {
		socket.close();
	}

	private native void joinChannel(String token) /*-{
		var channel = new $wnd.goog.appengine.Channel(token);
		var socket = channel.open();
		var listener = this.@com.google.gwt.channelapi.client.Channel::channelListener;

		socket.onopen = function() {
			listener.@com.google.gwt.channelapi.client.ChannelListener::onOpen()();
		}

		socket.onmessage = function(message) {
			listener.@com.google.gwt.channelapi.client.ChannelListener::onMessage(Ljava/lang/String;)(message.data);
		}

		socket.onerror = function(error) {
			listener.@com.google.gwt.channelapi.client.ChannelListener::onError(ILjava/lang/String;)(error.code, error.description);
		}

		socket.onclose = function() {
			listener.@com.google.gwt.channelapi.client.ChannelListener::onClose()();
		}
		
		this.@com.google.gwt.channelapi.client.Channel::socket = socket;
		
	}-*/;

}
