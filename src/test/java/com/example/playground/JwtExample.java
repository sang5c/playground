package com.example.playground;

import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class JwtExample {

    @Test
    void jwt() throws NoSuchAlgorithmException, InvalidKeyException {
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String payload = "{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"admin\":true}";

//        String header = """
//                {
//                  "alg": "HS256",
//                  "typ": "JWT"
//                }
//                """;
//        String payload = """
//                {
//                  "sub": "1234567890",
//                  "name": "John Doe",
//                  "admin": true
//                }
//                """;

        String encodedHeader = getBase64UrlEncoded(header.getBytes(StandardCharsets.UTF_8));
        System.out.println("헤더: " + encodedHeader); // A = ewogICJhbGciOiAiSFMyNTYiLAogICJ0eXAiOiAiSldUIgp9Cg

        String encodedPayload = getBase64UrlEncoded(payload.getBytes(StandardCharsets.UTF_8));
        System.out.println("페이로드: " + encodedPayload); // B = ewogICJzdWIiOiAiMTIzNDU2Nzg5MCIsCiAgIm5hbWUiOiAiSm9obiBEb2UiLAogICJhZG1pbiI6IHRydWUKfQo

        // HMAC SHA256으로 서명 생성
        String secret = "your-256-bit-secret"; // 서명을 위한 비밀키
        SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        sha256Hmac.init(keySpec);

        // 서명 생성 및 Base64 인코딩
        String data = encodedHeader + "." + encodedPayload;
        byte[] signatureBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        String signature = getBase64UrlEncoded(signatureBytes);
        System.out.println("서명: " + signature);

        String jwt = encodedHeader + "." + encodedPayload + "." + signature;
        System.out.println("JWT: " + jwt);
    }

    private String getBase64UrlEncoded(byte[] bytes) {
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(bytes);
    }
}
