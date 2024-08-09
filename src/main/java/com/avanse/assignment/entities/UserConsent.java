package com.avanse.assignment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor()
@AllArgsConstructor()
@Entity
public class UserConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long birthDate;
    private Long lan;
    private int consentVersion;

    public static UserConsentResObj toConsentResponseObj(UserConsent userConsent){
        return UserConsentResObj
                .builder().id(userConsent.getId())
                .name(userConsent.getName())
                .lan(userConsent.getLan())
                .birthDate(userConsent.getBirthDate())
                .consentVersion(userConsent.getConsentVersion()).build();
    }
}
