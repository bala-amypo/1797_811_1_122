@Entity
@Table(name="influencers")
public class Influencer {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String socialHandle;
    private boolean active=true;
    // getters & setters
}
