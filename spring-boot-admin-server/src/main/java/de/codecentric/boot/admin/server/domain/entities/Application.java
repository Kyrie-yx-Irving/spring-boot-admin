/*
 * Copyright 2014-2019 the original author or authors.
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

package de.codecentric.boot.admin.server.domain.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import org.springframework.util.Assert;

import de.codecentric.boot.admin.server.domain.values.BuildVersion;
import de.codecentric.boot.admin.server.domain.values.StatusInfo;

import static de.codecentric.boot.admin.server.domain.constant.Constant.DEFAULT_GROUP_NAME;

@lombok.Data
public final class Application {

	private final String name;

	private final String groupName;

	@Nullable
	private final BuildVersion buildVersion;

	private final String status;

	private final Instant statusTimestamp;

	private final List<Instance> instances;

	@lombok.Builder(builderClassName = "Builder", toBuilder = true)
	private Application(String name, @Nullable BuildVersion buildVersion, @Nullable String status,
			@Nullable Instant statusTimestamp, List<Instance> instances, @Nullable String groupName) {
		Assert.notNull(name, "'name' must not be null");
		Assert.notNull(instances, "'instances' must not be null");
		this.name = name;
		this.buildVersion = buildVersion;
		this.status = (status != null) ? status : StatusInfo.STATUS_UNKNOWN;
		this.statusTimestamp = (statusTimestamp != null) ? statusTimestamp : Instant.now();
		if (instances.isEmpty()) {
			this.instances = Collections.emptyList();
		}
		else {
			this.instances = new ArrayList<>(instances);

		}
		this.groupName = (groupName != null) ? groupName : DEFAULT_GROUP_NAME;
	}

	private Application(String name, @Nullable BuildVersion buildVersion, @Nullable String status,
			@Nullable Instant statusTimestamp, List<Instance> instances) {
		Assert.notNull(name, "'name' must not be null");
		Assert.notNull(instances, "'instances' must not be null");
		this.name = name;
		this.buildVersion = buildVersion;
		this.status = (status != null) ? status : StatusInfo.STATUS_UNKNOWN;
		this.statusTimestamp = (statusTimestamp != null) ? statusTimestamp : Instant.now();
		if (instances.isEmpty()) {
			this.instances = Collections.emptyList();
		}
		else {
			this.instances = new ArrayList<>(instances);

		}
		this.groupName = DEFAULT_GROUP_NAME;
	}

	public static Application.Builder create(String name) {
		return builder().name(name);
	}

	public static class Builder {

		// Will be generated by lombok

	}

}
