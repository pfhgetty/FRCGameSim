package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Containable;
import org.usfirst.irs1318.gamesim.engine.Container;

import java.util.Optional;

/**
 * The actor retrieves a containers from the origin container and stores it in its own container.
 */
public class Pick extends Action {
    public String payloadType;
    public Container source;
    public Container failure;
    public int quantity;

    @Override
    public void performSuccessAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Containable> payload = source.retrieveContents();
            payload.ifPresent(containable -> actor.addPayload(payloadType, containable));
        }
    }

    @Override
    public void performFailureAction() {
        for (int i = 0; i < quantity; i++) {
            source.retrieveContents().ifPresent(containable -> failure.placeContent(containable));
        }
    }
}
