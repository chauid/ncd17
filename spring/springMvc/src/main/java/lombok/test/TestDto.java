package lombok.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data  //위 3개 합친 기능
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor  //모든 변수를 인자로 갖는 생성자
public class TestDto {
	private String name;
	private String addr;
	private String hp;
}
