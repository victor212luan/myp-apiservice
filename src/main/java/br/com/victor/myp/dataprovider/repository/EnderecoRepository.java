package br.com.victor.myp.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.myp.dataprovider.entity.EnderecoTable;

public interface EnderecoRepository extends JpaRepository<EnderecoTable, Long>  {

}
