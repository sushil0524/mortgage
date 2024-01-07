package com.ing.mortgage.repository;

import com.ing.mortgage.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InterestRatesRepository extends JpaRepository<InterestRate, Integer> {
}
