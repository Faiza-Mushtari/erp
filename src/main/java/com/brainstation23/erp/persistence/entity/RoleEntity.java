package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.constant.EntityConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = EntityConstant.ROLE)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
	@Id
	@Type(type = "uuid-char")
	@JoinColumn(name="role_id")
	private UUID id;
	@Column(unique=true)
	private String role;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<UserEntity> users = new HashSet<>();
}
