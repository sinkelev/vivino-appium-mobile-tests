package org.sinkelev.data.user;

import org.sinkelev.drivers.capability.Capability;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private Capability capability;
}
