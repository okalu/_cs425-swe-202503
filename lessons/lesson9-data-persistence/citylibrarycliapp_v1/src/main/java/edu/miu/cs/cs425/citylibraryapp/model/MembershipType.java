package edu.miu.cs.cs425.citylibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "membership_types")
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer membershipTypeId;
    @NotNull
    private String membershipTypeName;
    private Double overdueFeePerDay;
    private Integer checkoutDurationInDays;
}
