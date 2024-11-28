package ma.ocp.RestControllers;

import ma.ocp.Dtos.PaymentDto;
import ma.ocp.Entities.Human_resourses.Payment;
import ma.ocp.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentServices paymentServices;

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentServices.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Optional<Payment> payment = paymentServices.getPayment(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(value="/Save" , consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Payment> createPayment(@RequestBody MultipartFile file,  PaymentDto paymentDto) {
        try {
            ;
            return ResponseEntity.ok(paymentServices.savePayment(file,paymentDto));
        }

        catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value="/Update" , consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Payment> updatePayment(@RequestBody MultipartFile file,  PaymentDto paymentDto) {
        try {
            paymentServices.savePayment(file,paymentDto);
            return ResponseEntity.ok().build();
        }

        catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentServices.removePayment(paymentServices.getPayment(id).get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/file/{id}" ,produces=MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPaymentFile(@PathVariable Long id) {
        try {
            byte[] file = paymentServices.getFile(this.paymentServices.getPayment(id).get());
            return ResponseEntity.ok(file);
            }
        catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
