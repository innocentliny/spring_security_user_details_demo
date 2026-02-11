package com.example.demo.controller;

import com.example.demo.config.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    /**
     * Call <code>curl -v http://localhost:8080/api/</code>
     */
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello~");
    }

    /**
     * 有看過別人在每個 API method 內都去讀取 DB 取得帳號角色或權限，
     * 再判斷是否可以呼叫此 API，
     * 這樣會造成 DB 負擔，
     * 這裡展示帳密驗證後，
     * 直接透過自訂 user details 物件取得想要的額外資訊即可。
     */
    @GetMapping("user")
    public ResponseEntity<String> user(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok("Hello from user( " + userDetails.getEmail() + " )~");
    }

    @GetMapping("admin")
    public ResponseEntity<String> admin(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok("Hello from admin( " + userDetails.getEmail() + " )~");
    }
}
