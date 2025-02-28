package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("BoardRepleDto")
public class BoardRepleDto {
	private int num;
	private int idx;
	private String myid;
	private String message;
	private String photo;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
	private String writer;
}
