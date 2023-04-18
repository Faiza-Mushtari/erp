package com.brainstation23.erp.service;

import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.RoleMapper;
import com.brainstation23.erp.model.domain.Role;
import com.brainstation23.erp.model.dto.CreateRoleRequest;
import com.brainstation23.erp.model.dto.UpdateRoleRequest;
import com.brainstation23.erp.persistence.entity.RoleEntity;
import com.brainstation23.erp.persistence.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleService {
	public static final String ROLE_NOT_FOUND = "Role Not Found";
	@Autowired
	private final RoleRepository roleRepository;

	@Autowired
	private final RoleMapper roleMapper;

	public Page<Role> getAll(Pageable pageable) {
		var entities =  roleRepository.findAll(pageable);
		return entities.map(roleMapper::entityToDomain);
	}

	public Role getOne(UUID id) {
		var entity = roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ROLE_NOT_FOUND));
		return roleMapper.entityToDomain(entity);
	}

	public UUID createOne(CreateRoleRequest createRequest) {
		var entity = new RoleEntity();
		entity.setId(UUID.randomUUID())
				.setName(createRequest.getName());
		var createdEntity = roleRepository.save(entity);
		return createdEntity.getId();
	}

	public void updateOne(UUID id, UpdateRoleRequest updateRequest) {
		var entity = roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ROLE_NOT_FOUND));
		entity.setName(updateRequest.getName());
		roleRepository.save(entity);
	}

	public void deleteOne(UUID id) {
		roleRepository.deleteById(id);
	}
}
