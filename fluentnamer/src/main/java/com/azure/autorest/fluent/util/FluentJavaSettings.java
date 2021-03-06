/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 *
 */

package com.azure.autorest.fluent.util;

import com.azure.autorest.extension.base.plugin.NewPlugin;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FluentJavaSettings {

    private final NewPlugin host;

    /**
     * Java class names for extra Inner classes.
     */
    private Set<String> javaNamesForAddInner;

    /**
     * Java class names for excluded Inner classes.
     */
    private Set<String> javaNamesForRemoveInner;

    /**
     * Whether to generate property method with track1 naming (e.g. foo, withFoo), instead of track2 naming (e.g. getFoo, setFoo).
     */
    private boolean track1Naming = false;

    /**
     * Whether to treat read-only resource property as SubResource type.
     */
    private boolean resourcePropertyAsSubResource = false;

    /**
     * Operation group name for ungrouped operations.
     */
    private Optional<String> nameForUngroupedOperations = Optional.empty();

    /**
     * Naming override.
     */
    private final Map<String, String> namingOverride = new HashMap<>();

    public FluentJavaSettings(NewPlugin host) {
        Objects.requireNonNull(host);
        this.host = host;

        loadSettings();
    }

    public Set<String> getJavaNamesForAddInner() {
        return javaNamesForAddInner;
    }

    public Set<String> getJavaNamesForRemoveInner() {
        return javaNamesForRemoveInner;
    }

    public boolean isTrack1Naming() {
        return track1Naming;
    }

    public boolean isResourcePropertyAsSubResource() {
        return resourcePropertyAsSubResource;
    }

    public Optional<String> getNameForUngroupedOperations() {
        return nameForUngroupedOperations;
    }

    public Map<String, String> getNamingOverride() {
        return namingOverride;
    }

    private void loadSettings() {
        String addInnerSetting = host.getStringValue("add-inner");
        if (addInnerSetting != null && !addInnerSetting.isEmpty()) {
            javaNamesForAddInner = Arrays.stream(addInnerSetting.split(Pattern.quote(",")))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toSet());
        } else {
            javaNamesForAddInner = Collections.emptySet();
        }

        String removeInnerSetting = host.getStringValue("remove-inner");
        if (removeInnerSetting != null && !removeInnerSetting.isEmpty()) {
            javaNamesForRemoveInner = Arrays.stream(removeInnerSetting.split(Pattern.quote(",")))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toSet());
        } else {
            javaNamesForRemoveInner = Collections.emptySet();
        }

        loadBooleanSetting("track1-naming", b -> track1Naming = b);
        loadBooleanSetting("resource-property-as-subresource", b -> resourcePropertyAsSubResource = b);

        loadStringSetting("name-for-ungrouped-operations", s -> nameForUngroupedOperations = Optional.of(s) );

        Map<String, String> namingOverride = host.getValue(new TypeReference<Map<String, String>>() {}.getType(), "pipeline.fluentnamer.naming.override");
        if (namingOverride != null) {
            this.namingOverride.putAll(namingOverride);
        }
    }

    private void loadBooleanSetting(String settingName, Consumer<Boolean> action) {
        Boolean settingValue = host.getBooleanValue(settingName);
        if (settingValue != null) {
            action.accept(settingValue);
        }
    }

    private void loadStringSetting(String settingName, Consumer<String> action) {
        String settingValue = host.getStringValue(settingName);
        if (settingValue != null) {
            action.accept(settingValue);
        }
    }
}
