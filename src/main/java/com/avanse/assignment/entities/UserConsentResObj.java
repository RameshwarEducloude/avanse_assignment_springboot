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
    private String birthDate;
    private String lan;
    private String consentVersion;
    private String date;

    public static UserConsentResObj prepareReqToResponse1(UserConsentReqObj consentReqObj){
        return UserConsentResObj.builder()
                .name(consentReqObj.getName())
                .lan(consentReqObj.getLan())
                .birthDate(consentReqObj.getBirthDate())
                .date(consentReqObj.getDate())
                .consentVersion(consentReqObj.getConsentVersion()).build();
    }
}
