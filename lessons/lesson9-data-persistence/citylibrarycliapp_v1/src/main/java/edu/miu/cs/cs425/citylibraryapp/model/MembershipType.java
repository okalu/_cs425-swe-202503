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
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column=@Column(name="overdue_fee_amount")),
            @AttributeOverride(name="currency", column=@Column(name="overdue_fee_currency"))
    })
    private Money overdueFeePerDay;
    private Integer checkoutDurationInDays;

    public MembershipType(String membershipTypeName, Money overdueFeePerDay, Integer checkoutDurationInDays) {
        this.membershipTypeName = membershipTypeName;
        this.overdueFeePerDay = overdueFeePerDay;
        this.checkoutDurationInDays = checkoutDurationInDays;
    }
}
