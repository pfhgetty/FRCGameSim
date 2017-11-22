package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.*;

import java.util.Optional;

/**
 * The actor retrieves a containers from the origin container and stores it in its own container.
 */
public final class Pick extends Action {
    private final String payloadType;
    private final Container source;
    private final Container failure;
    private final int quantity;

    public Pick(Actor actor, TaskDetails taskDetails, String payloadType, Container source, Container failure, int quantity) {
        super(actor, taskDetails);
        this.payloadType = payloadType;
        this.source = source;
        this.failure = failure;
        this.quantity = quantity;
    }

    @Override
    public void performSuccessAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Containable> optionalPayload = source.retrieveContents();
            optionalPayload.ifPresent(payload -> actor.addPayload(payloadType, payload));
        }
    }

    @Override
    public void performFailureAction() {
        for (int i = 0; i < quantity; i++) {
            Optional<Containable> optionalPayload = source.retrieveContents();
            optionalPayload.ifPresent(failure::placeContent);
        }
    }

    public String getPayloadType() {
        return payloadType;
    }

    public Container getSource() {
        return source;
    }

    public Container getFailure() {
        return failure;
    }

    public int getQuantity() {
        return quantity;
    }
}
