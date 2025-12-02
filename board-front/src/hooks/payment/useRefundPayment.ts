// src/hooks/payment/useRefundPayment.ts
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { paymentApi } from "@/apis/payment/payment.api";
import { PAYMENT_KEYS } from "@/query/payment.keys";
import type { ResponseDto } from "@/types/common/ResponseDto";

interface RefundMutationPayload {
  paymentId: number;
  amount: number;
  reason?: string;
}

export const useRefundPayment = () => {
  const queryClient = useQueryClient();

  return useMutation<ResponseDto<PaymentResponse>, Error, RefundMutationPayload>({
    mutationFn: ({ paymentId, amount, reason }) =>
      paymentApi.refundPayment(paymentId, { amount, reason }),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: PAYMENT_KEYS.myList });
    },
  });
};