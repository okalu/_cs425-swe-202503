package edu.miu.cs.cs425.citylibraryapp.repository;

import edu.miu.cs.cs425.citylibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = "SELECT p FROM Publisher p JOIN FETCH p.primaryAddress")
    List<Publisher> getAllPublishers();

    @Query(
            value= """
                    select
                    p1_0.publisher_id,
                    p1_0.email,
                    p1_0.name,
                    p1_0.phone_number,
                    p1_0.primary_address_id,
                    pa1_0.address_id,
                    pa1_0.city,
                    pa1_0.state,
                    pa1_0.street,
                    pa1_0.zip_code
                  from
                    publishers p1_0
                  left join
                    addresses pa1_0
                        on pa1_0.address_id=p1_0.primary_address_id
        """,
            nativeQuery = true
    )
    List<Publisher> getAllPublishers2();

    // Spring Data JPA Query methods
    List<Publisher> findPublishersByNameContaining(String str);

    List<Publisher> findPublishersByNameContainingAndEmailIsEndingWithIgnoreCase(String name, String email);
}
