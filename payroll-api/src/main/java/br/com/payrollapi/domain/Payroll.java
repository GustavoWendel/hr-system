package br.com.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class Payroll implements Serializable {

    @Serial
    private static final long serialVersionUID = 6433201066026282456L;

    private String workerName;
    private String description;
    private Double hourlyPrice;
    private Double workerHours;
    private Double totalPayment;
}
