package com.mindwaresrl.egpp.repo;

import java.util.List;

public interface Repositorio<E> {

	public List<E> recuperarTodos();
	public E recuperar(String id);
}
