package com.eccehomo.eccebit.model;

import com.eccehomo.eccebit.enums.ROLE;
import com.eccehomo.eccebit.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private String mobile;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private UserStatus status= UserStatus.PENDING;

    private boolean isVerified = false;

    @Embedded
    private TwoFactorAuthentication twoFactorAuth= new TwoFactorAuthentication();

    private String picture;

    private ROLE role= ROLE.ROLE_USER;

}
