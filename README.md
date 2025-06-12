# ChatSpring MSA

간단한 Spring Boot MSA(Microservice Architecture) 예제입니다. 각 마이크로서비스는 Maven 멀티모듈 프로젝트로 구성되어 있습니다.

## 구성
- **gateway**: 루트 경로(`/`)에서 "Hello, World!" 문자열을 반환합니다.
- **greeting-service**: `/greeting` 경로에서 메시지를 반환합니다.
- **tracking-link API 연동**: gateway 모듈에서 Airbridge Tracking Link 목록과 세부 정보를 조회하는 엔드포인트(`/tracking-links/details`)를 제공합니다.
- Airbridge API 호출은 Spring Cloud OpenFeign을 사용합니다.

## 요구 사항
- Java 21 이상
- Maven 3.9+

## 빌드 및 실행
프로젝트 루트에서 모든 모듈을 빌드하려면 다음 명령을 실행하세요:

```bash
mvn -q package
```

개별 서비스는 각 모듈 디렉터리에서 개발 모드로 실행할 수 있습니다. 예:

```bash
cd gateway
mvn spring-boot:run
```

또는

```bash
cd greeting-service
mvn spring-boot:run
```

### Tracking Link API 사용

Airbridge API 호출을 위해 다음 프로퍼티를 설정할 수 있습니다.

```
airbridge.api.base-url=<기본값: https://api.airbridge.io>
airbridge.api.token=<발급받은 토큰>
airbridge.api.language=<기본값: ko>
```

모든 API 호출 시 `Authorization`과 `Accept-Language` 헤더가 전송됩니다. 세부 정보
조회에는 `idType` 파라미터가 사용되며 기본값은 `id`입니다.

`gateway` 모듈을 실행한 뒤 `/tracking-links/details` 엔드포인트를 호출하면 목록 조회 후 각 항목의 세부 정보를 반환합니다. 먼저 `from`과 `to` 값만 사용해 전체 목록의 `totalCount`를 얻은 뒤 페이지 번호(`pagNo`)와 페이지 크기(`pgaCnt`)에 맞춰 현재 페이지의 항목만 조회합니다. `pgaCnt` 값은 목록 API의 `size` 파라미터로 전달되어 한 번에 가져올 항목 수를 의미합니다. `from`, `to`와 함께 페이지 번호 `pagNo`, 페이지 크기 `pgaCnt`를 전달하여 원하는 페이지를 조회할 수 있습니다.

예시:

```bash
curl "http://localhost:8080/tracking-links/details?from=2023-04-01&to=2023-04-02&pagNo=1&pgaCnt=10"
```

응답 JSON에는 전체 항목 수를 나타내는 `allCnt`와 해당 페이지의 상세 목록이 포함됩니다.
