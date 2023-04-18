package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Organization;
import com.brainstation23.erp.model.dto.OrganizationResponse;
import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T05:22:22+0600",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organization entityToDomain(OrganizationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setId( entity.getId() );
        organization.setName( entity.getName() );
        organization.setCode( entity.getCode() );

        return organization;
    }

    @Override
    public OrganizationResponse domainToResponse(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationResponse organizationResponse = new OrganizationResponse();

        organizationResponse.setId( organization.getId() );
        organizationResponse.setName( organization.getName() );
        organizationResponse.setCode( organization.getCode() );

        return organizationResponse;
    }
}
