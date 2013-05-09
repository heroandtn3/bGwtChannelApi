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
		channel.join(new ChannelListener() {

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
	}
}
