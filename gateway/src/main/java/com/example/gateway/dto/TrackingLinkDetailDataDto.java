package com.example.gateway.dto;

/**
 * 트래킹 링크 상세 응답의 각 필드를 표현하는 DTO 입니다.
 * Airbridge API의 응답 구조와 거의 동일하게 매핑됩니다.
 */
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OgTag getOgTag() {
        return ogTag;
    }

    public void setOgTag(OgTag ogTag) {
        this.ogTag = ogTag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    public FallbackPaths getFallbackPaths() {
        return fallbackPaths;
    }

    public void setFallbackPaths(FallbackPaths fallbackPaths) {
        this.fallbackPaths = fallbackPaths;
    }

    public CampaignParams getCampaignParams() {
        return campaignParams;
    }

    public void setCampaignParams(CampaignParams campaignParams) {
        this.campaignParams = campaignParams;
    }

    public Boolean getIsReengagement() {
        return isReengagement;
    }

    public void setIsReengagement(Boolean isReengagement) {
        this.isReengagement = isReengagement;
    }

    /**
     * 링크 클릭 및 노출 정보를 담는 객체
     */
    public static class Link {
        /** 클릭 URL */
        private String click;
        /** 노출 URL */
        private String impression;
        /** 서버간 클릭 URL */
        private String serverToServerClick;

        public String getClick() {
            return click;
        }

        public void setClick(String click) {
            this.click = click;
        }

        public String getImpression() {
            return impression;
        }

        public void setImpression(String impression) {
            this.impression = impression;
        }

        public String getServerToServerClick() {
            return serverToServerClick;
        }

        public void setServerToServerClick(String serverToServerClick) {
            this.serverToServerClick = serverToServerClick;
        }
    }

    /**
     * 공유 시 사용되는 OG(Open Graph) 태그 정보
     */
    public static class OgTag {
        /** OG 제목 */
        private String title;
        /** OG 이미지 URL */
        private String imageUrl;
        /** OG 설명 */
        private String description;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    /**
     * 앱이 설치되지 않았을 때 사용되는 폴백 경로
     */
    public static class FallbackPaths {
        /** iOS 폴백 경로 */
        private String ios;
        /** 추가 옵션 */
        private Option option;
        /** Android 폴백 경로 */
        private String android;
        /** 데스크톱 폴백 URL */
        private String desktop;

        public String getIos() {
            return ios;
        }

        public void setIos(String ios) {
            this.ios = ios;
        }

        public Option getOption() {
            return option;
        }

        public void setOption(Option option) {
            this.option = option;
        }

        public String getAndroid() {
            return android;
        }

        public void setAndroid(String android) {
            this.android = android;
        }

        public String getDesktop() {
            return desktop;
        }

        public void setDesktop(String desktop) {
            this.desktop = desktop;
        }
    }

    /**
     * 추가 설정 정보를 담는 객체
     */
    public static class Option {
        /** iOS 커스텀 프로덕트 페이지 ID */
        private String iosCustomProductPageId;

        public String getIosCustomProductPageId() {
            return iosCustomProductPageId;
        }

        public void setIosCustomProductPageId(String iosCustomProductPageId) {
            this.iosCustomProductPageId = iosCustomProductPageId;
        }
    }

    /**
     * UTM 파라미터 등 캠페인 관련 값들을 담는 객체
     */
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

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getSubId() {
            return subId;
        }

        public void setSubId(String subId) {
            this.subId = subId;
        }

        public String getSubId1() {
            return subId1;
        }

        public void setSubId1(String subId1) {
            this.subId1 = subId1;
        }

        public String getSubId2() {
            return subId2;
        }

        public void setSubId2(String subId2) {
            this.subId2 = subId2;
        }

        public String getSubId3() {
            return subId3;
        }

        public void setSubId3(String subId3) {
            this.subId3 = subId3;
        }

        public String getAdGroup() {
            return adGroup;
        }

        public void setAdGroup(String adGroup) {
            this.adGroup = adGroup;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCampaign() {
            return campaign;
        }

        public void setCampaign(String campaign) {
            this.campaign = campaign;
        }

        public String getAdCreative() {
            return adCreative;
        }

        public void setAdCreative(String adCreative) {
            this.adCreative = adCreative;
        }
    }
}
