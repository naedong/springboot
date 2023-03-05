package kr.co.e4net.map;

public interface BaseMapper<D, E> {

	D toDto(E e);
	E toEntity(D d);

	
}
