package com.brainstation23.erp.service;

import com.brainstation23.erp.exception.custom.InvalidRequestException;
import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.RoleMapper;
import com.brainstation23.erp.model.domain.Role;
import com.brainstation23.erp.model.dto.CreateRoleRequest;
import com.brainstation23.erp.model.dto.UpdateRoleRequest;
import com.brainstation23.erp.persistence.entity.RoleEntity;
import com.brainstation23.erp.persistence.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleService {
	public static final String Role_NOT_FOUND = "Role Not Found";

	public static final String INVALID_REQUEST = "Invalid Request to create Role";

	private final RoleRepository roleRepository;
	private final RoleMapper roleMapper;

	public Page<Role> getAll(Pageable pageable) {
		var entities = roleRepository.findAll(pageable);
		return entities.map(roleMapper::entityToDomain);
	}

	public Role getOne(UUID id) {
		var entity = roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(Role_NOT_FOUND));
		return roleMapper.entityToDomain(entity);
	}

	public UUID createOne(CreateRoleRequest createRequest) {
		var entity = new RoleEntity();
		entity.setId(UUID.randomUUID())
				.setRole(createRequest.getRole());
		var createdEntity = roleRepository.save(entity);
		return roleRepository.findById(createdEntity.getId())
				.orElseThrow(() -> new InvalidRequestException(INVALID_REQUEST))
				.getId();
	}

	public void updateOne(UUID id, UpdateRoleRequest updateRequest) {
		var entity = roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(Role_NOT_FOUND));
		entity.setRole(updateRequest.getRole());
		roleRepository.save(entity);
	}

	public void deleteOne(UUID id) {
		roleRepository.deleteById(id);
	}
}
