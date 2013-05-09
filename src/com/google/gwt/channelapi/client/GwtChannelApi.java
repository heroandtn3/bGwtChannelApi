package com.google.gwt.channelapi.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtChannelApi implements EntryPoint {

	private Channel channel;
	private TextBox tbClientId;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		tbClientId = new TextBox();
		RootPanel.get().add(tbClientId);

		Button butJoin = new Button("Join");
		RootPanel.get().add(butJoin);
		butJoin.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				createChannel(tbClientId.getText());
			}
		});

		Button butExit = new Button("Exit");
		RootPanel.get().add(butExit);
		butExit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				channel.close();
			}
		});

		Button butSend = new Button("Send message");
		RootPanel.get().add(butSend);
		butSend.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				channel.sendMessage(tbClientId.getText(), "Hello World");
			}
		});

	}

	private void createChannel(String clientId) {
		channel = new Channel(clientId);
		channel.addChannelListener(new ChannelListener() {

			@Override
			public void onOpen() {
				System.out.println("on open");

			}

			@Override
			public void onMessage(String message) {
				System.out.println("on message: " + message);

			}

			@Override
			public void onError(int code, String description) {
				System.out.println("on error");

			}

			@Override
			public void onClose() {
				System.out.println("on close");

			}
		});
		channel.join();
	}
}
