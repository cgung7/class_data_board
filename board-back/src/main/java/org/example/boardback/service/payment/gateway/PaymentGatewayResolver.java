package org.example.boardback.service.payment.gateway;

import lombok.RequiredArgsConstructor;
import org.example.boardback.common.enums.payment.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentGatewayResolver {

    private final MockPaymentGateway mockPaymentGateway;
    private final TossPayGateway tossPayGateway;
    private final KakaoPayGateway kakaoPayGateway;

    public PaymentGateway resolve(PaymentMethod method) {
        return switch (method) {
            case MOCK -> mockPaymentGateway;
            case TOSS_PAY -> tossPayGateway;
            case KAKAO_PAY -> kakaoPayGateway;
        };
    }
}
