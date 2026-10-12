package mostapha.bayi.ebankservice.feign;
import mostapha.bayi.ebankservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomersById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception e) {
        return new Customer(id, "Default Customer name", "Default Customer email");
    }
}
