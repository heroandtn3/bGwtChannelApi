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

	public void addChannelListener(ChannelListener channelListener) {
		this.channelListener = channelListener;
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

	public void join() {
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
