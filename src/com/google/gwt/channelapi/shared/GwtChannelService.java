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
