package com.yassine.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @author pc
 **/
@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String email;
}
