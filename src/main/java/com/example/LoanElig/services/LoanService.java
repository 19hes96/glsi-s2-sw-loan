package com.example.LoanElig.services;

import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.ObjectFactory;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public WsResponse getLoanStatus(CustomerRequest request){
        WsResponse response = new ObjectFactory().createWsResponse();
        if(request.getAge() < 25 || request.getAge() > 50){
            response.getCriteriaMismatch().add("Customer age must be between 25 and 50.");
        }
        if(request.getYearlyIncome()  < 10000){
            response.getCriteriaMismatch().add("Customer yearly income must be over 10000.");
        }
        if(request.getCibilScore()  < 500){
            response.getCriteriaMismatch().add("Customer cibile score must be over 500");
        }
        if(response.getCriteriaMismatch().isEmpty()){
            response.setIsEligeble(true);
            response.setApprovedAmount((long) ((50 - request.getAge()) * request.getYearlyIncome() * 0.4));
        }
        else{
            response.setIsEligeble(false);
            response.setApprovedAmount(0);
        }
        return response;
    }
}
