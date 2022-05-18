package com.example.LoanElig.endpoints;

import com.example.LoanElig.services.LoanService;
import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@AllArgsConstructor
public class LoanEndPoint {

    public static final String nameSpace ="http://www.tekup.de/loan/soap/ws/loanEligebilty";
    /*C:\Users\HOUSSEM\Documents\glsi_a\s2\SW\LoanElig\src\main\java\de\tekup\loan\soap\ws\loaneligebilty 3andi

     */


    private LoanService loanService;

    @PayloadRoot(namespace = nameSpace,localPart = "CustomerRequest")
    @ResponsePayload
    public WsResponse checkLoanStatus(@RequestPayload CustomerRequest customerRequest){
        return loanService.getLoanStatus(customerRequest);
    }
}
