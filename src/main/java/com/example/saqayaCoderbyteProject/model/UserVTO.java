package com.example.saqayaCoderbyteProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVTO {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean marketingConsent;

}
