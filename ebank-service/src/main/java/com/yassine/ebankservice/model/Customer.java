package com.yassine.ebankservice.model;

import lombok.*;

/**
 * @author pc
 **/
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}
