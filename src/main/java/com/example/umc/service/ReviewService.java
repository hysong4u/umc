package com.example.umc.service;

import com.example.umc.domain.Member;
import com.example.umc.domain.Review;
import com.example.umc.domain.Store;
import com.example.umc.dto.CreateReviewRequest;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.ReviewRepository;
import com.example.umc.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {

    public final ReviewRepository reviewRepository;
    public final MemberRepository memberRepository;
    public final StoreRepository storeRepository;

    @Transactional
    public Review createReview(final CreateReviewRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Store stores = storeRepository.findById(request.storeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Review review = Review.builder()
                .title(request.title())
                .content(request.content())
                .score(request.score())
                .member(member)
                .store(stores)
                .build();

        return reviewRepository.save(review);

    }

}
