/**
 * Copyright (C) 2010-2011, FuseSource Corp.  All rights reserved.
 *
 *     http://fusesource.com
 *
 * The software in this package is published under the terms of the
 * CDDL license a copy of which has been included with this distribution
 * in the license.txt file.
 */
package org.fusesource.fabric.zookeeper;

import java.util.Map;

import org.fusesource.fabric.zookeeper.internal.SimplePathTemplate;

/**
 * Set of paths which are used by fon.
 */
public enum ZkPath {


    // config nodes
    CONFIGS_AGENTS          ("/fabric/configs/agents/"),
    CONFIG_AGENT            ("/fabric/configs/agents/{agent}"),
    CONFIG_VERSIONS_PROFILES("/fabric/configs/versions/{version}/profiles"),
    CONFIG_VERSIONS_PROFILE ("/fabric/configs/versions/{version}/profiles/{profile}"),
    CONFIG_VERSIONS_AGENT   ("/fabric/configs/versions/{version}/agents/{agent}"),

    // Agent nodes
    AGENT           ("/fabric/registry/agents/config/{agent}"),
    AGENT_ALIVE     ("/fabric/registry/agents/alive/{agent}"),
    AGENT_IP        ("/fabric/registry/agents/config/{agent}/ip"),
    AGENT_ROOT      ("/fabric/registry/agents/config/{agent}/root"),
    AGENT_JMX       ("/fabric/registry/agents/config/{agent}/jmx"),
    AGENT_SSH       ("/fabric/registry/agents/config/{agent}/ssh");

    /**
     * Path template.
     */
    private SimplePathTemplate path;

    private ZkPath(String path) {
        this.path = new SimplePathTemplate(path);
    }

    /**
     * Gets path.
     *
     * @param args Values of path variables.
     * @return Path
     */
    public String getPath(String ... args) {
        return this.path.bindByPosition(args);
    }


    /**
     * Gets path.
     *
     * @param args Values of path variables.
     * @return Path
     */
    public String getPath(Map<String, String> args) {
        return this.path.bindByName(args);
    }

}
