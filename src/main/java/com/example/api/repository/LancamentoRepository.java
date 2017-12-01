package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
