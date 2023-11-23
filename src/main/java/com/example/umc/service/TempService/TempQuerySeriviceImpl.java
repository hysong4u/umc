package com.example.umc.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQuerySeriviceImpl implements TempQueryService{
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new RuntimeException("flag is 1");
        }
    }
}
