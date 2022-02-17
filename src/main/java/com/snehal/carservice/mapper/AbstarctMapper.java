package com.snehal.carservice.mapper;

import org.modelmapper.ModelMapper;

public abstract class AbstarctMapper<J, D, P> { // implements IMapper{

  protected static final ModelMapper modelMapper = new ModelMapper();

  public D mapJsonDtoToDomain(J jsonDto) {
    D domain = (D) modelMapper.map(jsonDto, ((D) Object.class).getClass());
    return domain;
  }

  public P mapDomainToPersistable(D domain) {

    P persistable = (P) modelMapper.map(domain, ((P) Object.class).getClass());
    return persistable;
  }

  public D mapPersistableToDomain(P persistable) {
    D domain = (D) modelMapper.map(persistable, ((D) Object.class).getClass());
    return domain;
  }

  public J mapDomainToJson(D domain) {
    J jsonDto = (J) modelMapper.map(domain, ((J) Object.class).getClass());
    return jsonDto;
  }
}
