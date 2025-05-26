package io.vladprotchenko.recipientservice.repository;

import io.vladprotchenko.recipientservice.model.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}
