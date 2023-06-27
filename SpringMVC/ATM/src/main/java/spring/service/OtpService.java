package spring.service;

import java.time.LocalDateTime;

public interface OtpService {
    boolean matchOtp(String obtainedOtp, String username);
}
