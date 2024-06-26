package com.unleash.consultationservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.unleash.consultationservice.DTO.PaymentDto;
import com.unleash.consultationservice.Service.serviceInterface.PromocodeService;
import com.unleash.consultationservice.Service.serviceInterface.SubscriptionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultation/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private PromocodeService promocodeService;

    @GetMapping("/payment/{amount}")
    public String Payment(@PathVariable String amount,@RequestHeader ("userId") int userId) throws RazorpayException {

        return subscriptionService.createOrder(amount, userId);
    }

    @PutMapping("/payment/update")
    public ResponseEntity<?> updatePayment(@RequestBody PaymentDto dto){
        if(subscriptionService.updateOrder(dto)){
            return ResponseEntity.ok().body("Subscription Sussess");
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/check-Subscription")
    public ResponseEntity<?>checkSubscription(@RequestHeader ("userId") int userId ){
        if(subscriptionService.isSubscribed(userId)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }

    @GetMapping("/check-promocode")
    public ResponseEntity<?> checkPromocode(@RequestParam ("promocode") String promocode){
        return promocodeService.getPromocodeDetails(promocode);
    }

}
