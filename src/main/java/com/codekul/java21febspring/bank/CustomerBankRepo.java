package com.codekul.java21febspring.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerBankRepo extends JpaRepository<CustomerBank,Long> {

    @Query(value = "select * from fn_get_accountnumber_count()",nativeQuery = true)
    Long getAccCount();
}
