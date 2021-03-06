package org.jenkinsci.lib.envinject.service;

import hudson.Plugin;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.Hudson;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * @author Gregory Boissinot
 * @deprecated The actual version of this API class is located in EnvInject API Plugin
 */
@Deprecated
@Restricted(NoExternalUse.class)
public class EnvInjectDetector {

    public boolean isEnvInjectActivated(AbstractBuild build) {

        if (build == null) {
            throw new NullPointerException("A build object must be set.");
        }

        EnvInjectActionRetriever envInjectActionRetriever = new EnvInjectActionRetriever();
        Action envInjectAction = envInjectActionRetriever.getEnvInjectAction(build);
        return envInjectAction != null;
    }

    public boolean isEnvInjectPluginInstalled() {
        Plugin envInjectPlugin = Jenkins.getActiveInstance().getPlugin("envinject");
        return envInjectPlugin != null;
    }
}
