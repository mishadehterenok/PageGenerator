package by.mdhtrnk.pagegenerator.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pages")
public class PageEntity extends BaseEntity{

    private String title;

    private String description;

    @Column(unique = true)
    private String slug;

    @Column(unique = true)
    private String menu_label;

    private String h1;

    private String content;

    private LocalDateTime published_at;

    private Integer priority;
}
