package br.com.victor.myp.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.myp.dataprovider.entity.UsuarioTable;

public interface UsuarioRepository extends JpaRepository<UsuarioTable, Long>  {

}
