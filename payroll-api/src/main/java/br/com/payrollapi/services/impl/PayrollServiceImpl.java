package br.com.payrollapi.services.impl;

import br.com.payrollapi.domain.Payroll;
import br.com.payrollapi.domain.User;
import br.com.payrollapi.feignclients.UserFeignClient;
import br.com.payrollapi.services.PayrollService;
import br.com.payrollapi.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static feign.FeignException.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final Environment env;
    private final UserFeignClient userFeign;


    @Override
    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = userFeign.findById(workerId).getBody();

            if (Objects.nonNull(user)) {
                return getPayroll(payroll, user);
            }
        } catch (FeignClientException e) {
            throw new ResourceNotFoundException("Resource Not Found");
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        return null;
    }

    private static Payroll getPayroll(Payroll payroll, User user) {
        return new Payroll(
                user.getName(),
                payroll.getDescription(),
                user.getHourlyPrice(),
                payroll.getWorkerHours(),
                user.getHourlyPrice() * payroll.getWorkerHours()
        );
    }
}
