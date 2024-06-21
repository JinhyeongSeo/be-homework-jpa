package com.springboot.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Stamp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stampId;

	@Column(nullable = false)
	private int stampCount;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
	private LocalDateTime modifiedAt = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	public void setMember(Member member) {
		if (!member.getStamp().equals(this)){
			member.setStamp(this);
		}
		this.member = member;

	}
}
