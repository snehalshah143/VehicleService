package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.IDomain;
import com.snehal.carservice.model.dto.AbstractJsonDto;
import com.snehal.carservice.model.persistable.AbstractPerstistable;
// <J extends IJsonDto,D extends IDomain,P extends IPerstistable>

public interface IMapper {

  IDomain mapJsonDtoToDomainObject(AbstractJsonDto jsonDto);

  AbstractPerstistable mapDomainToPersistableObject(IDomain domain);

  IDomain mapPersistableToDomainObject(AbstractPerstistable persistable);

  AbstractJsonDto mapDomainJsonDtoObject(IDomain domain);
}
