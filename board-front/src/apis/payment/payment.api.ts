import type {
  PaymentCreateRequest,
  PaymentApproveRequest,
  PaymentRefundRequest,
  PaymentResponse,
  PaymentMethod,
  KakaoReadyResponse
} from "@/types/payment/payment.dto";

import { privateApi } from "../common/axiosInstance";
import type { ResponseDto } from "@/types/common/ResponseDto";

export const paymentApi = {
  // 결제 생성 (Mock, KakaoReady)
  createPayment: async (body: PaymentCreateRequest) => {
    const res = await privateApi.post<
      ResponseDto<PaymentResponse | KakaoReadyResponse>
    >("/api/v1/payments", body);

    return res.data.data;
  },

  // 결제 승인
  approvePayment: async (body: PaymentApproveRequest) => {
    const res = await privateApi.post<ResponseDto<PaymentResponse>>(
      "/api/v1/payments/approve",
      body
    );

    return res.data.data;
  },

  // 내 결제 목록 조회
  getMyPayments: async (): Promise<PaymentResponse[]> => {
    const res = await privateApi.get<ResponseDto<PaymentResponse[]>>(
      "/api/v1/payments/me"
    );
    return res.data.data ?? [];
  },

  // 결제 환불
  refundPayment: async (paymentId: number, body: PaymentRefundRequest) => {
    const res = await privateApi.post<ResponseDto<void>>(
      `/api/v1/payments/${paymentId}/refund`,
      body
    );
    return res.data.data;
  },

  // 결제 수단 조회
  getPaymentMethods: async () => {
    const res = await privateApi.get<ResponseDto<PaymentMethod[]>>(
      "/api/v1/payments/methods"
    );
    return res.data.data;
  },
};
