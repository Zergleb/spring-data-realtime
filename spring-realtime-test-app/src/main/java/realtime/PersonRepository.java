package realtime;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "person", exported = true)
public interface PersonRepository extends
		PagingAndSortingRepository<Person, Long> {
}
