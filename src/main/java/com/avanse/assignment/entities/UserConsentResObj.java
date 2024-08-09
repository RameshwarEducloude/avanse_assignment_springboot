package com.avanse.assignment.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserConsentResObj {

    private Long id;
    private String name;
    private Long birthDate;
    private Long lan;
    private int consentVersion;
}
