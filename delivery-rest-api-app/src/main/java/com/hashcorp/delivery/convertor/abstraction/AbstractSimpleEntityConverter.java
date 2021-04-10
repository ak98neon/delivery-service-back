package com.hashcorp.delivery.convertor.abstraction;

public abstract class AbstractSimpleEntityConverter<E, DTO> implements ForwardConverter<E, DTO>,
	BackwardConverter<E, DTO> {

	private final ModelMapperService modelMapperService;

	protected AbstractSimpleEntityConverter(ModelMapperService modelMapperService) {
		this.modelMapperService = modelMapperService;
	}

	private ModelMapperService getModelMapperService() {
		return modelMapperService;
	}

	protected abstract Class<E> getEntityClass();

	protected abstract Class<DTO> getDtoClass();

	@Override
	public E convertBackward(DTO dto) {
		return getModelMapperService().convert(dto, getEntityClass());
	}

	@Override
	public DTO convert(E entity) {
		return getModelMapperService().convert(entity, getDtoClass());
	}

	@Override
	public boolean supports(Class<? extends E> clazz) {
		return getEntityClass().equals(clazz);
	}

}
