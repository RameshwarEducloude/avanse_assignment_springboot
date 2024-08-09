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
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ConsentController {

    @Autowired
    ConsentService consentService;

    /*
        This controller  use for Single-page solution
     */
    @GetMapping("/")
    public String goForUserConsent() {
        return "consentSinglepage";
    }

    /*
        This controller  use for Two-page solution by using Thymeleaf
    */
    @GetMapping("/consentformpage")
    public String fillConsentInfoPage() {
        return "consentFormPage";
    }

    @PostMapping("/saveconsent")
    public void saveConsent(@RequestBody UserConsentReqObj requestObject, HttpServletResponse response) throws IOException {
        JSONObject responseObject = new JSONObject();
        try {
            if (StringUtils.hasText(requestObject.getName()) && requestObject.getBirthDate() != null && requestObject.getLan() != null) {
                // convert request object to entity
                UserConsent userConsent = UserConsentReqObj.toConsent(requestObject);
                // save entity in database
                consentService.saveUserConsent(userConsent);
                // convert updated entity into response Object
                UserConsentResObj resObj = UserConsent.toConsentResponseObj(userConsent);
                // pass resObject into json to send UI
                responseObject.put(CommonConstants.STATUS, true);
                responseObject.put(CommonConstants.DATA, JSONObject.fromObject(resObj));
            } else {
                responseObject.put(CommonConstants.STATUS, false);
                responseObject.put(CommonConstants.ERROR_MESSAGE, CommonConstants.PARAMETERS_ARE_MISSING);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            responseObject.put(CommonConstants.STATUS, false);
            responseObject.put(CommonConstants.ERROR_MESSAGE, e.getMessage());
        }
        CommonUtility.writeDataInResponse(response, responseObject.toString());
    }


    /*
        This controller use for Two-page solution by using Thymeleaf
        Forward to second page
    */
    @PostMapping("/confirmconsent")
    public String confirmConsent(@ModelAttribute UserConsentReqObj requestObject, Model responceModel) {
        try {
            if (StringUtils.hasText(requestObject.getName()) && StringUtils.hasText(requestObject.getBirthDate()) && StringUtils.hasText(requestObject.getLan()) && StringUtils.hasText(requestObject.getConsentVersion())) {
                // Here converting Request object to response object
                UserConsentResObj responseObject = requestObject.toResponce(requestObject);
                responceModel.addAttribute("userConsent", responseObject);

            } else {
                responceModel.addAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.PARAMETERS_ARE_MISSING);
                return "consentFormPage";
            }
        } catch (Exception e) {
            responceModel.addAttribute(CommonConstants.ERROR_MESSAGE, e.getMessage());
            return "consentFormPage";
        }
        return "confirmConsent";
    }

}
