# imyeomsu
##  Imyeomsu - Lck X 우리은행 
클라우드 환경에서 고가용성 고려한 탄력적 서비스를 위한 LCK X 우리은행 ImYeomSu 팀의 서비스 입니다.
---
# ImYeomSu Server
- [크롤링](https://github.com/I-m-YeomSu/imyeomsu-crawling)
- [배치 서버](https://github.com/I-m-YeomSu/imyeomsu-batch)
- [코드 재사용성을 위한 공통 모듈](https://github.com/I-m-YeomSu/imyeomsu-lck-common-utils)

---
# 아키텍처
## 애플리케이션 아키텍처
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/1625c015-3eab-4c6a-97c5-b7932ef1678d)


## 시스템 아키텍처
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/0bed8ca7-52c9-4991-8ed7-3fe22dbd5afd)


---
# 서비스 설명
## 사용 기술 스택 - 서비스
### 프론트 엔드
<div>
    <img src="https://img.shields.io/badge/-HTML-E34F26?style=flat&logo=Html5&logoColor=white"/>
    <img src="https://img.shields.io/badge/-CSS-1572B6?style=flat&logo=CSS3&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Javascript-F7DF1E?style=flat&logo=javascript&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Bootstrap-7952B3?style=flat&logo=bootstrap&logoColor=white"/>
    <img src="https://img.shields.io/badge/-JQuery-0769AD?style=flat&logo=JQuery&logoColor=white"/>
</div>


### 백엔드
<div>
  <img src="https://img.shields.io/badge/-SpringBoot-6DB33F?style=flat&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Spring Security-6DB33F?style=flat&logo=springsecurity&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Spring Data Jpa-6DB33F?style=flat&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Query Dsl-4695EB?style=flat&logoColor=white"/>
</div>

### 형상 관리
<div>
  <img src="https://img.shields.io/badge/-Git-F05032?style=flat&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/-GitHub-181717?style=flat&logo=GitHub&logoColor=white"/>
</div>

### 데이터베이스
<div>
  <img src="https://img.shields.io/badge/-Mysql-4479A1?style=flat&logo=MySQL&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Redis-DC382D?style=flat&logo=Redis&logoColor=white"/>
</div>

### 테스트
<div>
  <img src="https://img.shields.io/badge/-Junit5-25A162?style=flat&logo=Junit5&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Mockito-41AD48?style=flat"/>
  <img src="https://img.shields.io/badge/-Jacoco-891B26?style=flat/>
  <img src="https://img.shields.io/badge/-Coverrals-173B3F?style=flat"/>
</div>

### 로그
<div>
  <img src="https://img.shields.io/badge/-Logback-E1763F?style=flat"/>
  <img src="https://img.shields.io/badge/-Slf4j-189C01?style=flat" />
</div>


### 기타 
<img src="https://img.shields.io/badge/-Jitpack-33485C?style=flat"/>

### 협업 툴
<div>
  <img src="https://img.shields.io/badge/-Slack-4A154B?style=flat&logo=Slack&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Notion-000000?style=flat&logo=Notion&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Google Sheets-34A853?style=flat&logo=Google Sheets&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Google Slides-FBBC04?style=flat&logo=Google Slides&logoColor=white"/>
</div>

## 구현부 상세 설명 - 서비스
### 1. 인증/인가
- 세션을 이용한 사용자 로그인 유지
- 분산 환경에서 서버가 여러대인 경우를 고려한 세션 스토리지 도입
- 세션 스토리지로 Redis 사용

### 세션 유지를 위한 Redis(Session Storage)
- [분산 환경에서 세션 유지를 위해서 우리는 왜 redis를 선택했으며, 세션 스토리지 방식을 채택했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/85)


## 트러블 슈팅
### 1. 동시성 이슈 해결 
- [우리는 왜 레디스를 도입해서 분산 환경에서의 동시성 이슈를 해결했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/83)
- [싱글 쓰레드인 레디스를 이용한 동시성 이슈 해결 방법](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/84)

----

# 인프라 설명
## 우리는 왜 EKS를 선택했을까?

---
# 배포
## CI/CD 플로우
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/0e7ff775-65fb-46d9-8f01-f8f891c05e67)
- [EKS 환경에서의 CI/CD는 어떻게 진행했을까?]()
## 배포 플로우

---
# 로그와 모니터링
## 로그 모니터링 플로우
### 1. 애플리케이션 로그 플로우 
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/a36c826e-8201-44f6-89b1-97b7d805e7b2)
- [우리는 어떻게 애플리케이션 레벌의 로그를 정제하고 사용했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/86)

---
# 트러블 슈팅


## 대용량 트래픽 해결

## 테스트 커버리지


### 테스트 커버리지 80%를 목표로 합니다.

