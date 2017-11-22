package org.usfirst.irs1318.gamesim.engine;

import java.util.Set;

public abstract class Task {
    protected final String name;
    protected final Set<Action> actions;
    protected final Set<Dependency> dependencies;

    public Task(String name, Set<Action> actions, Set<Dependency> dependencies) {
        this.name = name;
        this.actions = actions;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public Set<Dependency> getDependencies() {
        return dependencies;
    }
}
