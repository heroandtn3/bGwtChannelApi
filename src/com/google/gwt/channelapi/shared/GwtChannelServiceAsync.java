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
package com.google.gwt.channelapi.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author heroandtn3
 *
 */
public interface GwtChannelServiceAsync {

	void getToken(String clientId, AsyncCallback<String> callback);

	void sendMessage(String clientId, String message, AsyncCallback<Void> callback);

}
