package com.avanse.assignment;

import com.avanse.assignment.entities.UserConsent;
import com.avanse.assignment.entities.UserConsentReqObj;
import com.avanse.assignment.entities.UserConsentResObj;
import com.avanse.assignment.utility.CommonConstants;
import com.avanse.assignment.utility.CommonUtility;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedOutputStream;
import java.io.IOException;

@Controller
public class ConsentController {

    @Autowired
    ConsentService consentService;

    @GetMapping("/")
    public String goForUserConsent() {
        return "consentpage";
    }

    @PostMapping("/saveconsent")
    public void saveConsent(@RequestBody UserConsentReqObj userConsentReqObj, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        try {
            if (StringUtils.hasText(userConsentReqObj.getName()) && userConsentReqObj.getBirthDate() != null
                    && userConsentReqObj.getLan() != null) {
                UserConsent userConsent = UserConsentReqObj.toConsent(userConsentReqObj);
                UserConsentResObj resObj = consentService.saveUserConsent(userConsent);
                jsonObject.put(CommonConstants.STATUS, true);
                jsonObject.put(CommonConstants.DATA, JSONObject.fromObject(resObj));
            } else {
                jsonObject.put(CommonConstants.STATUS, false);
                jsonObject.put(CommonConstants.ERROR_MESSAGE, CommonConstants.PARAMETERS_ARE_MISSING);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            jsonObject.put(CommonConstants.STATUS, false);
            jsonObject.put(CommonConstants.ERROR_MESSAGE, e.getMessage());
        }
        CommonUtility.writeDataInResponse(response, jsonObject.toString());
    }


    @GetMapping("/fillconsentinfo")
    public String fillConsentInfoPage(Model model) {
//        model.addAttribute(CommonConstants.ERROR_MESSAGE , "Error message for testing");
        return "fillConsentInfo";
    }

    @GetMapping("/confirmconsent/{userName}/{lan}/{birthDate}/{consentVersion}")
    public String confirmConsent(@PathVariable String userName, @PathVariable long lan,
                                 @PathVariable Long birthDate, @PathVariable int consentVersion, Model model) {
        try {
            if (StringUtils.hasText(userName) && birthDate != null
                    && lan != 0 && consentVersion != 0) {
                UserConsentResObj userConsentResObj = new UserConsentResObj();
                userConsentResObj.setName(userName);
                userConsentResObj.setBirthDate(birthDate);
                userConsentResObj.setLan(lan);
                userConsentResObj.setConsentVersion(consentVersion);

                model.addAttribute("userConsent", userConsentResObj);

            } else {
                model.addAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.PARAMETERS_ARE_MISSING);
                return "fillConsentInfo";
            }

        } catch (Exception e) {
            model.addAttribute(CommonConstants.ERROR_MESSAGE, e.getMessage());
            return "fillConsentInfo";
        }

        return "confirmConsent";
    }


}
