package com.drey.ussdapp.controllers;

import com.drey.ussdapp.domains.dtos.CreateUserDto;
import com.drey.ussdapp.responses.AppResponse;
import com.drey.ussdapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<AppResponse> createUser(@RequestBody CreateUserDto createUserDto,
                                                  @RequestHeader(value = "authKey", required = true) String authKey
                                                  ) {
        return ResponseEntity.ok(userService.createUser(createUserDto, authKey));
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<AppResponse> getUserByPhoneNumber(@PathVariable String phoneNumber,
                                                            @RequestHeader(value = "authKey", required = true) String authKey) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phoneNumber,authKey));
    }

    @PostMapping("/{userId}/deposit")
    public ResponseEntity<AppResponse> deposit(@PathVariable String pin, @RequestParam double amount,
                                               @RequestHeader(value = "authKey", required = true) String authKey) {
        return ResponseEntity.ok(userService.deposit(pin, amount,authKey));
    }

    @PostMapping("/{userId}/withdraw")
    public ResponseEntity<AppResponse> withdraw(@PathVariable String pin,
                                                @RequestParam double amount,
                                                @RequestHeader(value = "authKey", required = true) String authKey) {
        return ResponseEntity.ok(userService.withdraw(pin, amount,authKey));
    }

    @GetMapping("/{userId}/balance")
    public ResponseEntity<AppResponse> getBalance(@PathVariable String pin,
                                                  @RequestHeader(value = "authKey", required = true) String authKey) {
        return ResponseEntity.ok(userService.getBalance(pin,authKey));
    }
}
