package edu.miu.cs.cs425.citylibraryapp.repository;

import edu.miu.cs.cs425.citylibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
