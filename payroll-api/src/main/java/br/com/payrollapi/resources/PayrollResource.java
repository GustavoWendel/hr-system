package br.com.payrollapi.resources;

import br.com.payrollapi.domain.Payroll;
import br.com.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
    }
}
