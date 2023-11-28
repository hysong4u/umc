package com.example.umc.controller;

import com.example.umc.domain.Review;
import com.example.umc.dto.CreateReviewRequest;
import com.example.umc.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(
            @RequestBody final CreateReviewRequest request) {
        reviewService.createReview(request);
        return ResponseEntity.noContent().build();
    }
}
