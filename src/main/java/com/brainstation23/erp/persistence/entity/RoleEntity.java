package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.constant.EntityConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Entity(name = EntityConstant.ROLE)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {
	@Id
	@Type(type = "uuid-char")
	private UUID id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleType name;
}
