package com.Studen.Startup.Response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class WalletResponse {

    private Integer id;
    private String bankAccountNumber;
}
