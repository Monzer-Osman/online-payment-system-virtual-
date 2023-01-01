package com.Fawry.payment_system.Services;

import com.Fawry.payment_system.Models.Refund;
import com.Fawry.payment_system.Repositories.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundService {

    private RefundRepository refundRepository;

    public RefundService(RefundRepository refundRepository){
        this.refundRepository = refundRepository;
    }

    public void addRefundRequest(Refund refundRequest){
        refundRepository.save(refundRequest);
    }


    public List<Refund> getAllRefundRequests() {
        return refundRepository.findAll();
    }
}
