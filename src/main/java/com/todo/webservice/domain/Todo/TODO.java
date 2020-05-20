package com.todo.webservice.domain.Todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TODO {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String isDone;
	private String img;
	
	@Builder
	public TODO(String title, String isDone, String img) {
		this.title = title;
		this.isDone = isDone;
		this.img = img;
	}
}
