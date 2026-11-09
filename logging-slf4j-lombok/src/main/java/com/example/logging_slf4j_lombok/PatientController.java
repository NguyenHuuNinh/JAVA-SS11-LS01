package com.example.logging_slf4j_lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @PostMapping
    public String addPatient(@RequestBody Patient patient) {
        // Ghi log INFO hiển thị tên bệnh nhân vừa được gửi lên
        log.info("Tiếp nhận bệnh nhân mới: {}", patient.getName());

        // Ghi log WARN nếu tuổi bệnh nhân > 120
        if (patient.getAge() > 120) {
            log.warn("Cảnh báo: Tuổi của bệnh nhân {} quá cao ({} tuổi)!", patient.getName(), patient.getAge());
        }

        return "Đã tiếp nhận bệnh nhân: " + patient.getName();
    }
}