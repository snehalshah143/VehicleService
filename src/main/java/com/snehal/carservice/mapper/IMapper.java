package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.IDomain;
import com.snehal.carservice.model.dto.IJsonDto;
import com.snehal.carservice.model.persistable.IPerstistable;
//<J extends IJsonDto,D extends IDomain,P extends IPerstistable>
public interface IMapper{ 

	IDomain mapJsonDtoToDomainObject(IJsonDto jsonDto); 
	
	IPerstistable mapDomainToPersistableObject(IDomain domain);
	
	IDomain mapPersistableToDomainObject(IPerstistable persistable) ;
	
	IJsonDto mapDomainJsonDtoObject(IDomain domain) ;
}
