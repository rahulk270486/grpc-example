package org.example.client.model;

import java.io.Serializable;

public record Weather(String temperature, String condition) implements Serializable {
}
