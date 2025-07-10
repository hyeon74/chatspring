package com.example.gateway.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 페이징 처리된 트래킹 링크 상세 목록을 나타내는 DTO 입니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingLinkPageOutputDto {
    /** 전체 항목 수 */
    private int allCnt;
    /** 현재 페이지의 상세 목록 */
    private List<TrackingLinkDetailOutputDto> items;
}
