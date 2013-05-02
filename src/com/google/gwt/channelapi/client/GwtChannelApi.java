package com.google.gwt.channelapi.client;

import com.google.gwt.core.client.EntryPoint;

public class GwtChannelApi implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Channel channel = new Channel("Sang");
		channel.addChannelListener(new ChannelListener() {
			
			@Override
			public void onOpen() {
				System.out.println("on open");
				
			}
			
			@Override
			public void onMessage(String message) {
				System.out.println("on message");
				
			}
			
			@Override
			public void onError(int code, String description) {
				System.out.println("on error");
				
			}
			
			@Override
			public void onClose() {
				// TODO Auto-generated method stub
				
			}
		});
		channel.join();
	}
}
