package br.com.victor.myp.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.myp.dataprovider.entity.EstadoTable;

public interface EstadoRepository extends JpaRepository<EstadoTable, Long>  {

}
