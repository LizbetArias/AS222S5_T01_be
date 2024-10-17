package pe.edu.vallegrande.OpenIA.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("open_ai_query") // Maps to the corresponding database table
public class OpenAiQuery {

    @Id
    private Long id; // Auto-generated by R2DBC, handled by the database

    private String prompt;

    @Column("response")
    private String response;

    private LocalDateTime timestamp;

    // This constructor ensures timestamp is automatically set upon creation
    public OpenAiQuery(String prompt, String response) {
        this.prompt = prompt;
        this.response = response;
        this.timestamp = LocalDateTime.now();
    }
}
