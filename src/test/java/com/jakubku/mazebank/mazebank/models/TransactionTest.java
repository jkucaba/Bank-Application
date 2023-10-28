package com.jakubku.mazebank.mazebank.models;

import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransactionTest {
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        transaction = new Transaction("Sender", "Receiver", 100.0, LocalDate.now(), "Message");
    }

    @Test
    public void testReceiverPropertyWhenReceiverIsSetThenReturnCorrectValue() {
        // Arrange
        String expectedReceiver = "New Receiver";
        transaction = new Transaction("Sender", expectedReceiver, 100.0, LocalDate.now(), "Message");

        // Act
        StringProperty receiverProperty = transaction.receiverProperty();

        // Assert
        assertEquals(expectedReceiver, receiverProperty.get(), "The receiver property should return the correct value");
    }

    @Test
    public void testReceiverPropertyWhenReceiverIsNullThenReturnNull() {
        // Arrange
        transaction = new Transaction("Sender", null, 100.0, LocalDate.now(), "Message");

        // Act
        StringProperty receiverProperty = transaction.receiverProperty();

        // Assert
        assertNull(receiverProperty.get(), "The receiver property should return null when receiver is null");
    }

    @Test
    public void testReceiverPropertyWhenReceiverIsSetThenReturnReceiver() {
        // Arrange
        String expectedReceiver = "Receiver";

        // Act
        String actualReceiver = transaction.receiverProperty().get();

        // Assert
        assertEquals(expectedReceiver, actualReceiver, "The receiver returned by receiverProperty() should be equal to the expected receiver.");
    }

    @Test
    public void testReceiverPropertyWhenReceiverIsSetToDifferentValueThenReturnReceiver() {
        // Arrange
        String expectedReceiver = "New Receiver";
        transaction.receiverProperty().set(expectedReceiver);

        // Act
        String actualReceiver = transaction.receiverProperty().get();

        // Assert
        assertEquals(expectedReceiver, actualReceiver, "The receiver returned by receiverProperty() when set to a different value should be equal to the expected receiver.");
    }
}