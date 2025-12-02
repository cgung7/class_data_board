import { useQuery } from "@tanstack/react-query";
import { paymentApi } from "@/apis/payment/payment.api";
import type { PaymentMethod } from "@/types/payment/payment.dto";
import type { ResponseDto } from "@/types/common/ResponseDto";

export const usePaymentMethods = () => {
  return useQuery<ResponseDto<PaymentMethod[]>>({
    queryKey: ["paymentMethods"],
    queryFn: () => paymentApi.getPaymentMethods(),
  });
};