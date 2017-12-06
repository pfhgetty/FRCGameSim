package org.usfirst.irs1318.gamesim.engine.activities;

import org.usfirst.irs1318.gamesim.engine.actors.Actor;
import org.usfirst.irs1318.gamesim.engine.container.Container;
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails;

import java.util.Optional;

/**
 * The actor takes an object from its container and places it into the destination.
 */
public final class Place extends Activity {
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
    public void performSuccessActivity() {
        for (int i = 0; i < quantity; i++) {
            Optional<Container> optionalPayloadContainer = actor.getPayloadContainer(payloadType);
            optionalPayloadContainer.ifPresent(payloadContainer ->
                    payloadContainer.retrieveContents().ifPresent(destination::placeContent));
        }
    }

    @Override
    public void performFailureActivity() {
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
