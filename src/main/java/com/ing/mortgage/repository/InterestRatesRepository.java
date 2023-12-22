package com.ing.mortgage.repository;

import com.ing.mortgage.model.InterestRates;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InterestRatesRepository extends JpaRepository<InterestRates, Integer> {
}
