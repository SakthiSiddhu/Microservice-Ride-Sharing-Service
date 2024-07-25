package com.ust.userservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "use_sequence")
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence")
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
}
