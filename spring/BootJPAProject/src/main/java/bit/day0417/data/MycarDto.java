package bit.day0417.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*JPA(Java Persistence API)
 * **엔티티?**
**JPA에서 엔티티는 테이블에 대응하는 하나의 클래스라고 생각하면 된다**
**spring-boot-starter-data-jpa 의존성을 추가하고 @Entiy 어노테이션을 붙이면 테이블과 자바 클래스가 매핑이 됩니다.
 */
@Entity
@Table(name = "jpamycar")  //db 에 jpamycar라는 테이블이 생성된다
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {	
	@Id  //각 엔터티를 구별할수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;	
	
	//@Column(name = "dbcarname")  //변수명과 달리 db 에는 dbcarname 으로 생성된다
	@Column(length = 30) //name 은 생략시 변수명과 같은 이름으로 컬럼명이 생성된다
	private String carname;
	
	private int carprice; //name은 같은이름으로 생성할거라 필요없고 나머지 설정도 없다면 @Column 생략가능
	
	@Column(length = 30)
	private String carcolor;
	
	@Column(length = 20)
	private String carimage;
	
	@Column(length = 20)
	private String carguip;
	
	//writeday 는 자동으로 현재시간으로 추가되야하고 수정시에는 제외되어야 한다
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp writeday;
	
	//@Transient: 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버변수
	@Transient
	private String message;
	
	@Transient
	private int commentcount;
}


























