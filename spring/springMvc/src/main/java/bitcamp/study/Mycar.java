package bitcamp.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component   //mycar 라는 이름으로 등록이된다
@Data
public class Mycar {
	@Value("아우디 A6")
	private String mycarName;
	@Value("진주색")
	private String mycarColor;

}
