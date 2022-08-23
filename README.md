# jpa_study1 에서 확인할것..
그외의 폴더들은 잘못 push함..

마리아db 연동해서 spring-date-jpa 어플리케이션을 만들어 봄.

실제로는 테이블이 없어도 
application.properties 에서 spring.jpa.hibernate.ddl-auto=create 속성이 테이블을 새로 만들어 줌

디펜던시는 참고하시고 

entity 패키지에 Member라는 Entity를 만들었음.
@Entity, @Getter, @NoArgsConstructor  이 3개 어노테이션은 필요한거같음, @Setter는 가급적 쓰지 말라고 함.
그리고 id에 @Id 어노테이션과 @GeneratedValue를만듦.
@GeneratedValue는 자동으로 id 생성해주는거임 auto_increment 같은거.. 이것도 속성이 있어서 다른방식으로 자동id생성할수잇음 궁금하면 검색 ㄱ

이것과 연결시킬 MemberRepository 동일한 패키지에 만들고,
JpaRepository<Member,Long> 를 extends 시켜준다. 
제네릭 처음 파라미터로는 엔티티가, 두번째 파라미터는 엔티티 ID 값의 type이 들어간다.
이것을 상속받기만 해도 crud 메소드를 사용할수 있다. 

MemberController 에서 실행 해봤다


잘된다. 아직 기초적인것만 해본단계라 많은 내용은 없당ㅎ





