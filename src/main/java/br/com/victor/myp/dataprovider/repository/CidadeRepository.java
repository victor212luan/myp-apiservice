package br.com.victor.myp.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.myp.dataprovider.entity.CidadeTable;

public interface CidadeRepository extends JpaRepository<CidadeTable, Long>  {

}
