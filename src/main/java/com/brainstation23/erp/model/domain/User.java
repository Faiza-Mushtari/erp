package com.brainstation23.erp.model.domain;

import com.brainstation23.erp.persistence.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Type(type = "uuid-char")
	private UUID id;
	private String username;
	private String email;
	private String password;
	private Set<RoleEntity> roles = new HashSet<>();
}
