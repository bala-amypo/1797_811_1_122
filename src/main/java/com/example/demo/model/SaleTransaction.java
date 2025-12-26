@Entity
@Table(name="sales")
public class SaleTransaction {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private Long customerId;

    @ManyToOne
    private DiscountCode discountCode;
    // getters & setters
}
