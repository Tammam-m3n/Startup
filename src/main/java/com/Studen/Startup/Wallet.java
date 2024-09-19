package com.Studen.Startup;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.jdbc.TinyIntAsSmallIntJdbcType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Wallet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_id"
    )
    @SequenceGenerator(
            allocationSize = 1,
            name = "wallet_id",
            sequenceName = "wallet_id"
    )
    private Integer id;
    private String bankAccountNumber;
}
