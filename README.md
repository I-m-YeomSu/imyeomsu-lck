# Imyeomsu - Lck X 우리은행 
클라우드 환경에서 고가용성을 고려한 탄력적 서비스, LCK X 우리은행 ImYeomSu 팀의 서비스 입니다.
## ImYeomSu Server
- [ImYeomsu - crawling Server](https://github.com/I-m-YeomSu/imyeomsu-crawling)
- [ImYeomsu - Batch Server](https://github.com/I-m-YeomSu/imyeomsu-batch)
- [ImYeomsu - Common Utils Server](https://github.com/I-m-YeomSu/imyeomsu-lck-common-utils)

# Application
## Application Architecture
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/1625c015-3eab-4c6a-97c5-b7932ef1678d)

## Skills
### Front-end - 프론트엔드
<div>
    <img src="https://img.shields.io/badge/-HTML-E34F26?style=flat&logo=Html5&logoColor=white"/>
    <img src="https://img.shields.io/badge/-CSS-1572B6?style=flat&logo=CSS3&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Javascript-F7DF1E?style=flat&logo=javascript&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white"/>
    <img src="https://img.shields.io/badge/-Bootstrap-7952B3?style=flat&logo=bootstrap&logoColor=white"/>
    <img src="https://img.shields.io/badge/-JQuery-0769AD?style=flat&logo=JQuery&logoColor=white"/>
</div>

### Back-end - 백엔드
<div>
  <img src="https://img.shields.io/badge/-SpringBoot-6DB33F?style=flat&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Spring Security-6DB33F?style=flat&logo=springsecurity&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Spring Data Jpa-6DB33F?style=flat&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Query Dsl-4695EB?style=flat&logoColor=white"/>
</div>

### Version Control - 형상 관리
<div>
  <img src="https://img.shields.io/badge/-Git-F05032?style=flat&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/-GitHub-181717?style=flat&logo=GitHub&logoColor=white"/>
</div>

### DataBase - 데이터베이스 
<div>
  <img src="https://img.shields.io/badge/-Mysql-4479A1?style=flat&logo=MySQL&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Redis-DC382D?style=flat&logo=Redis&logoColor=white"/>
</div>

### Test - 테스트
<div>
  <img src="https://img.shields.io/badge/-Junit5-25A162?style=flat&logo=Junit5&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Mockito-41AD48?style=flat"/>
  <img src="https://img.shields.io/badge/-Jacoco-891B26?style=flat/>
  <img src="https://img.shields.io/badge/-Coverrals-173B3F?style=flat"/>
</div>

### Log - 로그
<div>
  <img src="https://img.shields.io/badge/-Logback-E1763F?style=flat"/>
  <img src="https://img.shields.io/badge/-Slf4j-189C01?style=flat" />
</div>


### ETC - 기타 
<img src="https://img.shields.io/badge/-Jitpack-33485C?style=flat"/>
[WBS](https://docs.google.com/spreadsheets/d/1I1WK-1JCvNs0hG4PDDv7Ypw4TtAw7-VgCnqHPtyDScw/edit#gid=0)

### Collaboration tool - 협업 툴
<div>
  <img src="https://img.shields.io/badge/-Slack-4A154B?style=flat&logo=Slack&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Notion-000000?style=flat&logo=Notion&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Google Sheets-34A853?style=flat&logo=Google Sheets&logoColor=white"/>
  <img src="https://img.shields.io/badge/-Google Slides-FBBC04?style=flat&logo=Google Slides&logoColor=white"/>
</div>

## Implement Details - Service 
### 1. Authentication/Authorization
- 세션을 이용한 사용자 로그인 유지
- 분산 환경에서 서버가 여러대인 경우를 고려한 세션 스토리지 도입
- 세션 스토리지로 Redis 사용

### 세션 유지를 위한 Redis(Session Storage)
- [분산 환경에서 세션 유지를 위해서 우리는 왜 redis를 선택했으며, 세션 스토리지 방식을 채택했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/85)

### 1. Concurrency Problem Sorving - 동시성 문제 해결
- 기존의 싱글 스레드를 제공하는 레디스를 세션 스토리지로 사용하고 있어 추가적인 인프라 구성이 없어 이를 동시성 문제 해결에 도입하고자 했다. 그러나 이 역시 분산 환경에서는 문제가 되었고 추가적으로 분산 환경에서의 동시성 문제 해결을 위해서 레디스 분산 락을 이용해서 이를 해결했다.
- [싱글 쓰레드인 레디스를 이용한 동시성 이슈 해결 방법 - 동시성 문제 해결 (단일 서버)](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/84)
- [우리는 왜 레디스를 도입해서 분산 환경에서의 동시성 이슈를 해결했을까? - 동시성 문제 해결 (분산 서버)](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/83)

# Infra
## System Architecture
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/0bed8ca7-52c9-4991-8ed7-3fe22dbd5afd)

## 우리는 왜 EKS를 선택했을까?
- [임염수 팀이 EKS를 선택한 이유는 무엇일까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/87)
- [우리 팀은 도커 컴포즈 대신 K8S를 사용한 이유가 무엇일까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/89)

## CI/CD
### 1. CI/CD Flow
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/0e7ff775-65fb-46d9-8f01-f8f891c05e67)

### 2. CI/CD Pipeline
- [EKS 환경에서의 CI/CD는 어떻게 진행했을까?]()

## Deploy Flow - 배포

## Log and Monitoring - 로그와 모니터링 
### 1. Application Log and Monitoring
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/a36c826e-8201-44f6-89b1-97b7d805e7b2)
- [우리는 어떻게 애플리케이션 레벨의 로그를 정제하고 사용했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/86)

### 2. System Metric 
- [우리는 어떻게 메트릭 정보를 모니터링 했고 추후 어떻게 더 발전시켜 반영할 것인가?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/88)

## 대용량 트래픽 해결

## 테스트 커버리지


### 테스트 커버리지 80%를 목표로 합니다.

