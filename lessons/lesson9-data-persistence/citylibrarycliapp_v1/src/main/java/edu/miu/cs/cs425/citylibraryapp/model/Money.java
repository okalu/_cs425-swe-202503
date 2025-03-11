package edu.miu.cs.cs425.citylibraryapp.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record Money(
        Double amount,
        String currency
) {
}
