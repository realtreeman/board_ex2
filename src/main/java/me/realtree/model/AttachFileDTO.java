package me.realtree.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttachFileDTO {
	//attach 파일을 자바스크립트로 변환 시킴
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
}
