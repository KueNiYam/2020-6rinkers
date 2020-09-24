# :cocktail: [칵테일픽](https://cocktailpick.com)

<div align="center" style="display:flex;">
    <img src="./front/public/image/logo/CocktailPick_logo_FullName_white.png" width="450" alt="logo"/>
</div>

> 좋은 술을, 고민 없이

---
<br>

# 1. :grin: 서비스 소개
* 칵테일 픽은 칵테일 정보 제공, 추천 서비스입니다. "좋은 술을, 고민 없이"라는 모토를 가지고 개발하고 있습니다.
---
<br>

# 2. :two_men_holding_hands: 팀원 소개
* [그니](https://github.com/KueNiYam)
* [두강](https://github.com/ParkDooWon)
* [라테](https://github.com/minuyim)
* [무늬](https://github.com/JinJuMoon)
* [작은곰](https://github.com/KimGyeong)
* [토니](https://github.com/toneyparky)
* 보고 싶은 하비까지, 팀 "마시는 여섯들"입니다!  


### 팀문화로는 총 11가지가 있고 계속하여 보완하고 있습니다.
1. 말 아끼다가 :poop:된다.  
좋은 아이디어가 있어도 말하지 않는다면 아무도 모릅니다. 설령 확신이 없는 의견이었더라도 팀에게 영감을 불어넣어줄 수 있습니다.
2. 롤링롤 (Rolling Role)  
역할을 돌아가면서 함으로써 한 명이 계속 어려운 역할, 혹은 쉬운 역할을 하지 않습니다.
3. 근거 있어? 근거 있냐고!  
당신이 의견을 제시할 때는 근거를 제시해주세요. 근거가 없다면 의견에 대해 동료들은 당신의 의견에 동의하기가 어렵습니다.
4. 지각은 지갑을 앗아간다.  
당신의 지각은 당신의 지갑을 울게 합니다. 지각 1회 시 당신이 회식 자리에서 지불할 값이 1+1/5+1 가 됩니다.
5. 영상보다 실물이 이쁘세요.  
만날 수 있는 경우에는 만나서 업무를 진행합시다. 비대면으로 진행하는 경우보다 대면으로 진행하는게 더 즐겁습니다.
6. 나 그거 싫었어. 아 그랬구나~  
감정 회고는 중요합니다. 서로의 감정을 공유하면 팀은 더 화목해지고 끈끈해질 것입니다.
7. 회의의 중심에서 밥을 외쳐라 :raising_hand:‍  
당신의 의견을 존중되어야 합니다. 눈치보지 말고 당신의 의견을 말해주세요. 밥 시간이라고요? 모든 팀원들이 따라갈 겁니다.
8. TRT (Try, Refactor, Throw your table)  
일단 해봐라, 그리고 다시 해봐라, Just Do It! 정 안되면 모든 팀원에게 자신의 상황을 공유해라. 시도해 보는 것을 두려워 하지 말라. 
9. 당신의 머리를 믿지 마라. 당신의 글씨를 믿어라.  
기록은 중요합니다. 아무리 회의 때 좋은 의견이 나와도 정리하지 않으면 곧 날아갈 아이디어입니다. 정리하고 공유하는 습관을 가집시다.
10. 최선을 다 하면 온 우주가(팀원들) 당신을 도와줄 것이다.  
팀원이 열심히 무언가를 한다면, 다른 팀원들이 그것을 무시할 리 없습니다.
11. 말이 짧다...요?  
회의는 공적인 자리입니다. 서로에게 존칭과 존댓말을 사용한다면 회의가 감정적인 방향으로 치우치지 않을 것입니다.

 
---
<br>

# 3. :computer: 핵심 기능
* 칵테일 정보를 제공합니다.
    * 이름, 이미지, 어원, 특징, 도수, 맛, 레시피가 있습니다.
* 칵테일을 검색할 수 있습니다.
    * 칵테일 이름과 태그를 이용합니다.
* 칵테일을 추천합니다.
    * 사용자의 취향을 기반으로 합니다.
* 칵테일을 즐겨찾기할 수 있습니다.
---
<br>

# 4. :department_store: 프로젝트 구조
<p align="center"><img src="images/architecture.png"></p>

---
<br>

# 5. :video_game: 기술 스택
* Spring Boot
* Spring Data JPA
* Spring Security
* React
* Docker
* MariaDB
* Jenkins
* AWS EC2
* AWS S3
---
<br>

# 6. :open_file_folder: 업데이트 내역
* 0.0.1
    * 개발 환경 구축
    * 칵테일 관련 도메인 구현
    * 칵테일 다수 조회 구현
* 0.0.2
    * 로거 추가
    * API 문서화
    * 메타 / OG 태그 및 구글 애널리틱스 적용
    * 검색 기능 구현
* 0.0.3
    * 관리자 페이지의 칵테일 수정과 삭제 기능 구현
    * 칵테일 추천 방식을 개선
* 0.0.4
    * 유저 기능 추가 (구글 로그인)
    * 칵테일 즐겨찾기 기능 추가
    * 태그 검색 기능 추가
    * 칵테일 추천 알고리즘 보완
    * 카카오 공유 링크 추가
    * 무한 스크롤링 개선
* 0.0.5
    * UX / UI 개선
        * 로고 제작 및 추가
        * 사용자 행동 유도 메시지 추가
        * 사용자 행동 유도 모션 추가
        * 무한 스크롤 방식을 더 보기 버튼으로 수정
        * 푸터의 깃헙, 인스타그램 아이콘 클릭시 새 창이 열리도록 수정 
    * 버그 수정
        * 카카오 링크 개선
        * 프론트 예외처리 추가
        * 칵테일 태그 검색 비동기 버그 수정 
---
<br>

# 7. :pencil2: 추가 정보
- [인스타그램 주소](https://instagram.com/cocktail_pick)
- 이메일 주소 : 6rinkers@gmail.com
- [깃허브 레포지토리](https://github.com/woowacourse-teams/2020-6rinkers/)