package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.Refund;
import com.Fawry.payment_system.Services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;

@RestController
@RequestMapping("/Fawry-System/refunds/")
public class RefundController {

    private RefundService refundService;

    @Autowired
    public RefundController(RefundService refundService){
        this.refundService = refundService;
    }

    @GetMapping("/refund-requests")
    public List<Refund> getRefundRequests(){
        return refundService.getAllRefundRequests();
    }

    @PostMapping("/add-refund-request")
    public void refundRequest(@RequestBody Refund refundRequest){
        refundService.addRefundRequest(refundRequest);
    }
}
