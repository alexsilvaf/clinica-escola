package br.com.clinicaescola;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ClinicaEscolaApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private Validator validator;

	@Test
	void usesH2AndHibernate() throws SQLException {
		try (var connection = dataSource.getConnection()) {
			assertThat(connection.getMetaData().getDatabaseProductName()).isEqualTo("H2");
		}
		assertThat(entityManagerFactory.unwrap(SessionFactory.class)).isNotNull();
	}

	@Test
	void validatesNumericBoundsAndTextSize() {
		assertThat(validator.validate(new ValidationSample("Valido", 1))).isEmpty();
		assertThat(validator.validate(new ValidationSample("Valido", 10))).isEmpty();
		assertThat(validator.validate(new ValidationSample("Valido", 0)))
				.extracting(violation -> violation.getPropertyPath().toString()).containsExactly("capacity");
		assertThat(validator.validate(new ValidationSample("Valido", 11)))
				.extracting(violation -> violation.getPropertyPath().toString()).containsExactly("capacity");
		assertThat(validator.validate(new ValidationSample("A", 5)))
				.extracting(violation -> violation.getPropertyPath().toString()).containsExactly("name");
		assertThat(validator.validate(new ValidationSample("A".repeat(101), 5)))
				.extracting(violation -> violation.getPropertyPath().toString()).containsExactly("name");
	}

	@Test
	void lombokAnnotationProcessingWorks() {
		assertThat(new ValidationSample("Valido", 5).getName()).isEqualTo("Valido");
	}

	@Getter
	@RequiredArgsConstructor
	private static class ValidationSample {
		@NotBlank
		@Size(min = 2, max = 100)
		private final String name;

		@Min(1)
		@Max(10)
		private final int capacity;
	}
}
