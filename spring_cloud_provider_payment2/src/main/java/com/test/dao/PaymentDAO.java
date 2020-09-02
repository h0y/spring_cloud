package com.test.dao;

import com.test.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PaymentDAO {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
