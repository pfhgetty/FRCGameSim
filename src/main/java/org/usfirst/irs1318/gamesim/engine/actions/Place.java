package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Actor;
import org.usfirst.irs1318.gamesim.engine.Container;
import org.usfirst.irs1318.gamesim.engine.TaskDetails;

import java.util.Optional;

/**
 * The actor takes an object from its container and places it into the destination.
 */
public final class Place extends Action {
    private final String payloadType;
    private final Container destination;
    private final Container failure;
    private final int quantity;

    public Place(Actor actor, TaskDetails taskDetails, String payloadType, Container destination, Container failure, int quantity) {
        super(actor, taskDetails);
        this.payloadType = payloadType;
        this.destination = destination;
        this.failure = failure;
        this.quantity = quantity;
    }

    @Override
    public void performSuccessAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Container> optionalPayloadContainer = actor.getPayloadContainer(payloadType);
            optionalPayloadContainer.ifPresent(payloadContainer ->
                    payloadContainer.retrieveContents().ifPresent(destination::placeContent));
        }
    }

    @Override
    public void performFailureAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Container> optionalPayloadContainer = actor.getPayloadContainer(payloadType);
            optionalPayloadContainer.ifPresent(payloadContainer ->
                    payloadContainer.retrieveContents().ifPresent(failure::placeContent));
        }
    }

    public String getPayloadType() {
        return payloadType;
    }

    public Container getDestination() {
        return destination;
    }

    public Container getFailure() {
        return failure;
    }

    public int getQuantity() {
        return quantity;
    }
}
