package com.phantom.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phantom.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
