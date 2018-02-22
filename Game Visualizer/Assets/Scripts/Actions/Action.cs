using UnityEngine;
using System.Collections;

public abstract class Action
{
    public float startTime { get; private set; }
    public float endTime { get; private set; }
    private Actor actor;

    public Action(float startTime, float endTime, Actor actor)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.actor = actor;
    }
    /// <summary>
    /// Process an action. Time is given as time since start of game.
    /// </summary>
    /// <param name="time">Time since start of game.</param>
    public void Do(float time)
    {
        if (time <= endTime && time >= startTime)
        {
            this.Act(time - startTime, actor);
        }
    }

    /// <summary>
    /// Process this action. Time is given as time since start of action.
    /// </summary>
    /// <param name="time">Time since beginning of action.</param>
    protected abstract void Act(float time, Actor actor);
}