package com.gamorales.repository;

import org.springframework.data.repository.CrudRepository;

import com.gamorales.entity.Usuario;

public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{

}
