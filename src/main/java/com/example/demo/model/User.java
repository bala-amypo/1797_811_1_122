@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String email;
    private String role;
    private LocalDateTime createdAt=LocalDateTime.now();
    // getters & setters
}
