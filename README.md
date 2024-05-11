# imyeomsu
##  Imyeomsu - Lck X 우리은행 
클라우드 환경에서 고가용성 고려한 탄력적 서비스를 위한 LCK X 우리은행 ImYeomSu 팀의 서비스 입니다.

---
# 아키텍처
## 애플리케이션 아키텍처
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/1625c015-3eab-4c6a-97c5-b7932ef1678d)


## 시스템 아키텍처
![image](https://github.com/I-m-YeomSu/imyeomsu-lck/assets/81970382/0bed8ca7-52c9-4991-8ed7-3fe22dbd5afd)


---
# 서비스 설명
## 사용 기술 스택
### 프론트 엔드
html
css
javascript
bootstrap
jquery
thymeleaf

### 백엔드
spring boot
spring security
spring data jpa
queryDsl


### 형상 관리
git
github

### 데이터베이스
Mysql
Redis

### 테스트
junit5
mockito
jacoco
coverrals

### 로그
logstash
logback
slf4j

### 기타 
jitpack


## 인증/인가
- 세션을 이용한 사용자 로그인 유지
- 분산 환경에서 서버가 여러대인 경우를 고려한 세션 스토리지 도입
- 세션 스토리지로 Redis 사용

### 세션 유지를 위한 Redis(Session Storage)
- [분산 환경에서 세션 유지를 위해서 우리는 왜 redis를 선택했으며, 세션 스토리지 방식을 채택했을까?](https://github.com/I-m-YeomSu/imyeomsu-lck/issues/85)

## 배치

## 크롤링 

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

## 배포 플로우

---
# 로그와 모니터링
## 로그 모니터링 플로우

---
# 트러블 슈팅


## 대용량 트래픽 해결

## 테스트 커버리지


### 테스트 커버리지 80%를 목표로 합니다.

