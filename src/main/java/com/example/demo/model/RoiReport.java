@Entity
@Table(name="roi_reports")
public class RoiReport {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal totalSales=BigDecimal.ZERO;
    private int totalTransactions;
    private double roiPercentage;

    @ManyToOne
    private DiscountCode discountCode;
    // getters & setters
}
