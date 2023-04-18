package com.brainstation23.erp.model.domain;

import com.brainstation23.erp.persistence.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
	@Type(type = "uuid-char")
	private UUID id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleType name;
}
