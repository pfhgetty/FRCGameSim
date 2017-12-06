package org.usfirst.irs1318.gamesim.engine.objective;

import org.usfirst.irs1318.gamesim.engine.activities.Activity;

import java.util.Set;

public abstract class Task {
    protected final String name;
    protected final Set<Activity> gameActivities;
    protected final Set<Dependency> dependencies;

    public Task(String name, Set<Activity> gameActivities, Set<Dependency> dependencies) {
        this.name = name;
        this.gameActivities = gameActivities;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }

    public Set<Activity> getGameActivities() {
        return gameActivities;
    }

    public Set<Dependency> getDependencies() {
        return dependencies;
    }
}
