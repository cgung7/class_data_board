// src/hooks/payment/useMyPayments.ts

import { useQuery } from "@tanstack/react-query";
import { paymentApi } from "@/apis/payment/payment.api";
import { PAYMENT_KEYS } from "@/query/payment.keys";
import type { ResponseDto } from "@/types/common/ResponseDto";
import type { PaymentResponse } from "@/types/payment/payment.dto";

export const useMyPayments = () => {
  return useQuery<ResponseDto<PaymentResponse[]>>({
    queryKey: PAYMENT_KEYS.myList,
    queryFn: () => paymentApi.getMyPayments(),
  });
};