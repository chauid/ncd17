package bit.react.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jpashop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShopEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int num;
	
	@Column(length = 40)
	private String sangpum;
	
	@Column(length = 20)
	private String color;
	
	private int price;
	
	@Column(length = 100)
	private String photo;
	
	@Column(length = 20)
	private String sangguip;
	
	@Column(updatable = false) //수정시 제외
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
	@CreationTimestamp
	private Timestamp writeday;
}












