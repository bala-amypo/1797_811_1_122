@Entity
@Table(name="campaigns")
public class Campaign {
    @Id @GeneratedValue
    private Long id;
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    // getters & setters
}
