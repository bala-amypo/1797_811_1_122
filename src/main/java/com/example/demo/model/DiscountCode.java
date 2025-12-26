@Entity
@Table(name="discount_codes")
public class DiscountCode {
    @Id @GeneratedValue
    private Long id;
    private String codeValue;
    private double discountPercentage;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;
    // getters & setters
}
