package com.example.tgid.repository;


import com.example.tgid.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Integer> {

}

