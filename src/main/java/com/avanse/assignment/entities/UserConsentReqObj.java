package com.avanse.assignment.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserConsentReqObj {
    private String name;
    private Long birthDate;
    private Long lan;
    private int consentVersion;

    // create builder for create entity using userConsentReqObj
 public  static UserConsent toConsent(UserConsentReqObj userConsentReqObj){

        return UserConsent
                .builder()
                .name(userConsentReqObj.getName())
                .lan(userConsentReqObj.getLan())
                .birthDate(userConsentReqObj.getBirthDate())
                .consentVersion(userConsentReqObj.getConsentVersion()).build();
    }

}
