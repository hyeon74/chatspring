package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 트래킹 링크 상세 응답의 각 필드를 표현하는 DTO 입니다.
 * Airbridge API의 응답 구조와 거의 동일하게 매핑됩니다.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingLinkDetailDataDto {
    /** 링크 정보(click, impression 등) */
    private Link link;
    /** 연락용 이메일 주소 */
    private String email;
    /** OG 태그 정보 */
    private OgTag ogTag;
    /** 회사명 */
    private String company;
    /** 숏 링크 ID */
    private String shortId;
    /** 숏 링크 URL */
    private String shortUrl;
    /** 생성 시각(ISO-8601 문자열) */
    private String createdAt;
    /** 채널 이름 */
    private String channelName;
    /** 채널 타입 */
    private String channelType;
    /** 디퍼드 딥링크 URL */
    private String deeplinkUrl;
    /** 플랫폼별 폴백 경로 */
    private FallbackPaths fallbackPaths;
    /** 캠페인 파라미터 집합 */
    private CampaignParams campaignParams;
    /** 재활성화 링크 여부 */
    private Boolean isReengagement;

    /**
     * 링크 클릭 및 노출 정보를 담는 객체
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Link {
        /** 클릭 URL */
        private String click;
        /** 노출 URL */
        private String impression;
        /** 서버간 클릭 URL */
        private String serverToServerClick;
    }

    /**
     * 공유 시 사용되는 OG(Open Graph) 태그 정보
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OgTag {
        /** OG 제목 */
        private String title;
        /** OG 이미지 URL */
        private String imageUrl;
        /** OG 설명 */
        private String description;
    }

    /**
     * 앱이 설치되지 않았을 때 사용되는 폴백 경로
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FallbackPaths {
        /** iOS 폴백 경로 */
        private String ios;
        /** 추가 옵션 */
        private Option option;
        /** Android 폴백 경로 */
        private String android;
        /** 데스크톱 폴백 URL */
        private String desktop;
    }

    /**
     * 추가 설정 정보를 담는 객체
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option {
        /** iOS 커스텀 프로덕트 페이지 ID */
        private String iosCustomProductPageId;
    }

    /**
     * UTM 파라미터 등 캠페인 관련 값들을 담는 객체
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CampaignParams {
        private String term;      // 검색어
        private String subId;     // 광고 서브 식별자
        private String subId1;
        private String subId2;
        private String subId3;
        private String adGroup;   // 광고 그룹
        private String content;   // 광고 콘텐츠
        private String campaign;  // 캠페인명
        private String adCreative;// 광고 소재
    }
}
