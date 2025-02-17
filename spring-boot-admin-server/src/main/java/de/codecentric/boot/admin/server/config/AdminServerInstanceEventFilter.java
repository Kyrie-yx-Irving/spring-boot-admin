/*
 * Copyright 2014-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.codecentric.boot.admin.server.config;

import de.codecentric.boot.admin.server.domain.events.InstanceEvent;

/**
 * filter for Instance Event
 *
 * @author Kyrie-yx-Irving
 */

public interface AdminServerInstanceEventFilter {

	/**
	 * filter instanceEvent
	 * @param instanceEvent the event of the instance which registered in spring boot
	 * admin server
	 * @return true if the event is not have to be filtered.
	 */
	boolean filterForEvent(InstanceEvent instanceEvent);

}
