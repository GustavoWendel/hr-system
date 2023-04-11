package br.com.payrollapi.services;

import br.com.payrollapi.domain.Payroll;

public interface PayrollService {

    Payroll getPayment(Long workerId, Payroll payroll);
}
