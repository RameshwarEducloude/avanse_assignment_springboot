package com.avanse.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor()
@AllArgsConstructor()
public class UserConsentResObj {

    private Long id;
    private String name;
    private Long birthDate;
    private Long lan;
    private int consentVersion;

    public static UserConsentResObj prepareReqToResponse(UserConsentReqObj consentReqObj){
        return UserConsentResObj.builder()
                .name(consentReqObj.getName())
                .lan(consentReqObj.getLan())
                .birthDate(consentReqObj.getBirthDate())
                .consentVersion(consentReqObj.getConsentVersion()).build();
    }
}
