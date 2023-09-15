package com.quispesucso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quispesucso.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> 
{

}
