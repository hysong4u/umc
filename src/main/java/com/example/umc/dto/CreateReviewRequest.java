package com.example.umc.dto;

import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDateTime;

@Builder
public record CreateReviewRequest (

        String title,
        String content,
        Float score,
        Long storeId,
        Long memberId

) {

        public Review of(Review review, Store store, Member member) {
            return Review.builder()
                    .title(review.getTitle())
                    .content(review.getContent())
                    .score(review.getScore())
                    .store(store)
                    .member(member)
                    .build();
        }



}

