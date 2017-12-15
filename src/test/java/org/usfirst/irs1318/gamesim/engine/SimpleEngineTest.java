package org.usfirst.irs1318.gamesim.engine;

import org.junit.*;
import org.usfirst.irs1318.gamesim.engine.actions.Action;
import org.usfirst.irs1318.gamesim.engine.actors.Field;
import org.usfirst.irs1318.gamesim.engine.event.*;
import org.usfirst.irs1318.gamesim.engine.objective.*;
import scala.collection.immutable.HashSet;

public class SimpleEngineTest {
    // TODO Use ScalaTest
    @Test
    public void testSimpleMatch() {
        GameEngine gameEngine = GameEngine$.MODULE$.instance();

        Event switchToAuto = new Event(
                0,
                new Action.ChangePhase(
                        Field.Phase$.MODULE$.AUTO(),
                        new TaskDetails(
                                0,
                                0,
                                1.0f,
                                new Task(
                                        "switchToAuto",
                                        new HashSet<>(),
                                        new HashSet<>()
                                )
                        )
                )
        );

        Event switchToTeleop = new Event(
                15,
                new Action.ChangePhase(
                        Field.Phase$.MODULE$.TELEOP(),
                        new TaskDetails(
                                0,
                                0,
                                1.0f,
                                new Task(
                                        "switchToTeleop",
                                        new HashSet<>(),
                                        new HashSet<>()
                                )
                        )
                )
        );

        Event switchToPost = new Event(
                200,
                new Action.ChangePhase(
                        Field.Phase$.MODULE$.POST(),
                        new TaskDetails(
                                0,
                                0,
                                1.0f,
                                new Task(
                                        "switchToPost",
                                        new HashSet<>(),
                                        new HashSet<>()
                                )
                        )
                )
        );

        GameEngine.State state = GameEngine.State$.MODULE$.empty()
                .mapEventQueue(queue -> queue.$plus(switchToAuto))
                .mapEventQueue(queue -> queue.$plus(switchToTeleop))
                .mapEventQueue(queue -> queue.$plus(switchToPost));

        GameEngine.State newState = gameEngine.simulateState(state);

        Assert.assertEquals(newState.time(), 200);

        EventLog.Entry first = newState.eventLog().entries().head();
        Assert.assertEquals(first.content().get("action").get(), "ChangePhase");
        Assert.assertEquals(first.content().get("phase").get(), "auto");
        Assert.assertEquals(first.content().get("time").get(), "0");

        EventLog.Entry second = newState.eventLog().entries().drop(1).head();
        Assert.assertEquals(second.content().get("action").get(), "ChangePhase");
        Assert.assertEquals(second.content().get("phase").get(), "teleop");
        Assert.assertEquals(second.content().get("time").get(), "15");

        EventLog.Entry third = newState.eventLog().entries().drop(2).head();
        Assert.assertEquals(third.content().get("action").get(), "ChangePhase");
        Assert.assertEquals(third.content().get("phase").get(), "post");
        Assert.assertEquals(third.content().get("time").get(), "200");
    }
}
