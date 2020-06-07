package pl.paw.cinema.utils.serialization;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface DataTablesJpaRepository<T, ID extends Serializable> extends DataTablesRepository<T, ID>, JpaRepository<T, ID> {
}
