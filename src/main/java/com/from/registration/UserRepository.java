package com.from.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    User findByEmail(String email);

    // There is no need of writing any query for this because Spring Data JPA automatically generates a query based on the method name.

}

/*

=> Single Field Queries:

findByFirstName(String firstName)
findByLastName(String lastName)
findByUsername(String username)

=> Multiple Field Queries:

findByFirstNameAndLastName(String firstName, String lastName)
findByEmailOrUsername(String email, String username)
Sorting and Limiting Results:

findFirstByOrderByCreatedAtDesc() - Finds the latest entry by createdAt.
findTop3ByOrderByAgeDesc() - Finds the top 3 oldest entries.
Counting and Existence Checks:

countByAge(int age) - Counts entries with the specified age.
existsByEmail(String email) - Checks if a user with the given email exists.
Special Queries with Containing, StartingWith, EndingWith:

findByFirstNameContaining(String firstName) - Finds entries containing the given name.
findByLastNameStartingWith(String prefix) - Finds entries where lastName starts with the specified prefix.
Date Range Queries:

findByCreatedAtAfter(Date date) - Finds entries created after the specified date.
findByUpdatedAtBetween(Date startDate, Date endDate) - Finds entries updated within a range.
You can use combinations of these keywords to construct more complex queries without writing any JPQL or SQL.

*/
