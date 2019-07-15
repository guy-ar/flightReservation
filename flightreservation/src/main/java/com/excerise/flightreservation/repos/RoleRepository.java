package com.excerise.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excerise.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
