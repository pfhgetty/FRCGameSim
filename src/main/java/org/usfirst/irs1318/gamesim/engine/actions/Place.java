package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Container;

import java.util.Optional;

/**
 * The actor takes an object from its container and places it into the destination.
 */
public class Place extends Action {
    public String payloadType;
    public Container destination;
    public Container failure;
    public int quantity;

    @Override
    public void performSuccessAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Container> optionalPayloadContainer = actor.getPayloadContainer(payloadType);
            optionalPayloadContainer.ifPresent(payloadContainer ->
                    payloadContainer.retrieveContents().ifPresent(content ->
                            destination.placeContent(content)));
        }
    }

    @Override
    public void performFailureAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Container> optionalPayloadContainer = actor.getPayloadContainer(payloadType);
            // TODO
        }
    }
}
